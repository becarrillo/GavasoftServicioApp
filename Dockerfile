FROM openjdk:17-jdk-slim
ENV MYSQL_DBNAME=railway
ENV MYSQL_HOST=monorail.proxy.rlwy.net
ENV MYSQL_PASSWORD=wfstQjNkaYDDdqHfeUqLgphOdCnvGIbR
ENV MYSQL_PORT=29147
ENV MYSQL_USER=root
ARG SERVICIO_APP_JAR_FILE=servicio-app/target/servicio-app-0.0.1-SNAPSHOT.jar
COPY ${SERVICIO_APP_JAR_FILE} servicio-app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "servicio-app.jar"]