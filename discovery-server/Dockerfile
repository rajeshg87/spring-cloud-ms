FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/discovery-server-1.0.jar discovery-server-1.0.jar
ENTRYPOINT ["java", "-jar", "discovery-server-1.0.jar"]