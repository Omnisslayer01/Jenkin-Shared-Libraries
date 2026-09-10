def code(String github_url, String branch){
  echo "This is cloning your github repo"
  git url:github_url, branch:branch
}
