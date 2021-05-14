FROM openjdk:13-jdk-alpine3.10
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} server.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/server.jar"]