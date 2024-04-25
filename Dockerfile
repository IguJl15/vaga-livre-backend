FROM openjdk:21-jdk-slim-buster
MAINTAINER baeldung.com
COPY target/VagaLivreBackend-0.0.1-SNAPSHOT.jar VagaLivreBackend.jar
ENTRYPOINT ["java","-jar","/VagaLivreBackend.jar"]