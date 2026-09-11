def call(){
  sh "docker stop mysql_db django_cont nginx_cont || true"
  sh "docker rm mysql_db django_cont nginx_cont || true"

  sh "docker compose up"
}
