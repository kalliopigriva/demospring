FROM openJDK:21-jdk
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]