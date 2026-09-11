def call(String uername, String image_name, String version){
  sh "docker build -t ${username}/${image_name}:${version} ."
}
