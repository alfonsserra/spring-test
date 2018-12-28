workflow "New workflow" {
  on = "push"
  resolves = [
    "GitHub Action for Maven",
    "LucaFeger/actions/maven-cli@master",
  ]
}

action "GitHub Action for Maven" {
  uses = "./maven"
  args = "clean install test"
}

action "LucaFeger/actions/maven-cli@master" {
  uses = "LucaFeger/actions/maven-cli@master"
  args = "clean install"
}
