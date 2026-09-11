def call(String username, String image_name, String version){
  withCredentials([usernamePassword(
    'credentialsId':'DockerHub_Cred',
    usernameVariable:'DockerHubUser',
    passwordVariable:'DockerHubPassword'
  )]){
  sh 'docker login -u ${DockerHubUser} -p ${DockerHubPassword}'  
    // When writing credentials this line try to write them in ' ' as it is safer than " ", " " prints the password directly if there is an error, while ' ' doesnt
    // With ' ' you dont need to write ${env.DockerHubUser} as docker automatically resolves it for you. When using " " you need to write ${env.variable} for env variables
  sh "docker push ${username}/${image_name}:${version}"
  }
}
