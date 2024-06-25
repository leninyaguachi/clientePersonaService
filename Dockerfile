FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/ClientePersonaService-0.0.1-SNAPSHOT.jar ClientePersonaService.jar
ENTRYPOINT ["java","-jar","/ClientePersonaService.jar"]