def code(github_url,branch){
  echo "This is cloning your github repo"
  sh "git clone url:${github_url} branch:{branch}"
}
