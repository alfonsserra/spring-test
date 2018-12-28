workflow "New workflow" {
  on = "push"
  resolves = ["GitHub Action for Maven"]
}

action "GitHub Action for Maven" {
  uses = "./maven"
  args = "clean install"
}
