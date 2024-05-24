FROM openjdk:17
LABEL authors="hernan.inga"
COPY target/microservicio-cartera-0.0.1-SNAPSHOT.jar  cartera-app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "cartera-app.jar"]