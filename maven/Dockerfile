FROM maven:3.6.0-jdk-8-alpine

LABEL "name"="Maven Action"
LABEL "maintainer"="Alfons Serra <alfonsoserra@gmail.com>"
LABEL "version"="1.0.0"

LABEL "com.github.actions.name"="GitHub Action for Maven"
LABEL "com.github.actions.description"="Wraps the Maven to enable Maven commands."
LABEL "com.github.actions.icon"="package"
LABEL "com.github.actions.color"="orange"
COPY LICENSE README.md /

COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
