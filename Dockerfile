FROM openjdk:17.0.2-oracle
ADD target/ping-app-1.0.0.jar ping-app-1.0.0.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ping-app-1.0.0.jar"]