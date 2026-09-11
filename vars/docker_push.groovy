def call(String image_name, String version){
  withCredentials([usernamePassword(
    'credentialsId':'DockerHub_Cred',
    usernameVariable:'DockerHubUser',
    passwordVariable:'DockerHubPassword'
  )]){
  sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPassword}"
  sh "docker image tag notesapp ${env.DockerHubUser}/${image_name}:${version}"
  sh "docker push ${env.DockerHubUser}/${image_name}:${version}"
  }
}
