FROM openjdk:8-jdk
ARG JAR_FILE=target/nsoft-task-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} nsoft-task.jar
ENTRYPOINT ["java", "-jar", "/nsoft-task.jar"]