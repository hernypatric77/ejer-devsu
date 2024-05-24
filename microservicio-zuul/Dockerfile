FROM openjdk:11
LABEL authors="hernan.inga"
COPY target/microservicio-zuul-0.0.1-SNAPSHOT.jar zuul-app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "zuul-app.jar"]