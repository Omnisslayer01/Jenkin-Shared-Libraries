def call(String username, String image_name, String version){
  withCredentials([usernamePassword(
    'credentialsId':'DockerHub_Cred',
    usernameVariable:'DockerHubUser',
    passwordVariable:'DockerHubPassword'
  )]){
  sh 'docker login -u ${username} -p ${DockerHubPassword}'
  sh "docker push ${username}/${image_name}:${version}"
  }
}
