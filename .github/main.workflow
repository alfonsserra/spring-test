workflow "New workflow" {
  on = "push"
  resolves = [
    "GitHub Action for Maven",
  ]
}

action "GitHub Action for Maven" {
  uses = "systelab/github-actions/maven-cli@master"
  args = "clean install"
}
