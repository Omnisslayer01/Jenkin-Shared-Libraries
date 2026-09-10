def call(String container_name){
  sh "docker network create mynetwork || true"
  
  sh "docker stop mysql_db ${container_name} nginx || true"
  sh "docker rm mysql_db ${container_name} nginx || true"
  
  sh "docker run -d -p '3306:3306' --name mysql_db --network=mynetwork -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db mysql"
  sh "docker run -d -p '8000:8000' --name ${container_name} --network=mynetwork -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db -e MYSQL_HOST=mysql_db -e MYSQL_USER='root' ${container_name}"
  sh "docker run -d -p '80:80' --name nginx --network=mynetwork -v /nginx/default.conf nginx"
}
