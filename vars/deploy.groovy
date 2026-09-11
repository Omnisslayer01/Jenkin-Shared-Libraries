def call(String container_name){
  sh "docker network create mynetwork || true"
  
  sh "docker stop mysql_db django_app nginx || true"
  sh "docker rm mysql_db django_app nginx || true"
  
  sh "docker run -d -p '3306:3306' --name mysql_db --network=mynetwork -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db mysql"
  sh "docker run -d -p '8000:8000' --name django_app --network=mynetwork -e DB_PASSWORD=root -e DB_NAME=db -e DB_HOST=mysql_db -e DB_USER='root' ${container_name}"
  sh "docker run -d -p '80:80' --name nginx --network=mynetwork -v \$(pwd)/nginx/default.conf:/etc/nginx/conf.d/default.conf nginx"

  
}
