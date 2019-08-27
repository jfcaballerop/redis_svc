FROM openjdk:8-jdk-alpine
ADD /target/redissvc-0.0.1.jar redissvc-0.0.1.jar
ENTRYPOINT ["java", "-jar", "redissvc-0.0.1.jar"]