FROM openjdk:17-jdk-slim
ARG SERVICIO_APP_JAR_FILE=target/servicio-app-0.0.1-SNAPSHOT.jar
COPY ${SERVICIO_APP_JAR_FILE} servicio-app.jar

ENTRYPOINT ["java", "-jar", "servicio-app.jar"]