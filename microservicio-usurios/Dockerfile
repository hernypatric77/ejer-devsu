FROM openjdk:17
LABEL authors="hernan.inga"
COPY target/microservicio-usurios-0.0.1-SNAPSHOT.jar usuario-app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "usuario-app.jar"]