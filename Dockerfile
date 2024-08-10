FROM openjdk:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/my-api-0.0.1-SNAPSHOT-standalone.jar /my-api/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/my-api/app.jar"]
