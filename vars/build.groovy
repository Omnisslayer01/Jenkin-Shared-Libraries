def call(String uername, String image_name){
  sh "docker build -t ${username}/${image_name}:${version} ."
}
