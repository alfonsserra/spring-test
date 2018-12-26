[![Build Status](https://travis-ci.org/systelab/spring-test.svg?branch=master)](https://travis-ci.org/systelab/spring-test)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7ce4e563c45b4d09a975d61bed7d5d50)](https://www.codacy.com/app/systelab/spring-test?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=systelab/spring-test&amp;utm_campaign=Badge_Grade)
[![Known Vulnerabilities](https://snyk.io/test/github/systelab/spring-test/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/systelab/spring-test?targetFile=pom.xml)

#  Spring Test Fundamentals


## Getting Started

To get you started you can simply clone the `spring-test` repository and install the dependencies:

### Prerequisites

You need [git][git] to clone the `spring-test` repository.

You will need [Java™ SE Development Kit 8][jdk-download] and [Maven][maven].

### Clone `spring-test`

Clone the `spring-test` repository using git:

```bash
git clone https://github.com/systelab/spring-test.git
cd spring-test
```

### Install Dependencies

In order to install the dependencies and generate the Uber jar you must run:

```bash
mvn clean install
```

### Run

To launch the server, simply run with java -jar the generated jar file.

```bash
cd target
java -jar spring-test-1.0.jar
```

Or with the maven plugin:

```bash
mvn spring-boot:run
```


Head to http://localhost:8080 in order to see the Eureka Daskboard


## Docker

### Build docker image

There is an Automated Build Task in Docker Cloud in order to build the Docker Image. 
This task, triggers a new build with every git push to your source code repository to create a 'latest' image.
There is another build rule to trigger a new tag and create a 'version-x.y.z' image

You can always manually create the image with the following command:

```bash
docker build -t systelab/spring-test . 
```

### Run the container

```bash
docker run -p 8761:8761 systelab/spring-test
```

The app will be available at http://localhost:8080


[git]: https://git-scm.com/
[sboot]: https://projects.spring.io/spring-boot/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads
[JEE]: http://www.oracle.com/technetwork/java/javaee/tech/index.html
[eureka]: https://github.com/Netflix/eureka
