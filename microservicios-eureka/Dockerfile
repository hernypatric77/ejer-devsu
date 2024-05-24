FROM openjdk:17
LABEL authors="hernan.inga"
COPY target/microservicios-eureka-0.0.1-SNAPSHOT.jar eureka-app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-app.jar"]