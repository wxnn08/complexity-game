FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/my-api-0.0.1-SNAPSHOT-standalone.jar /app/my-api.jar

EXPOSE 8080

CMD ["java", "-jar", "my-api.jar"]
