# ns-task
NSoft Tasks
## Java & Maven
[How to download and install Java & Maven](https://toolsqa.com/maven/how-to-install-maven-on-windows)
## Kafka
### Install kafka locally
[How to install Kafka on Windows](https://www.geeksforgeeks.org/how-to-install-and-run-apache-kafka-on-windows/)
### or
### Run kafka in the docker container
```
> docker-compose up -d
> docker-compose up
```

Update bootstrapServers (KafkaConsumerConfig / KafkaProducerConfig) kafka bootstrap server to port 9093:
```
private String bootstrapServers = "localhost:9093";
```

### Kowl
Access kowl at:
http://localhost:8080

### Create new kafka topic directly in docker container
```
> docker exec -it kafka /bin/sh
> cd opt/bitnami/kafka/bin
> kafka-topics.sh --create --bootstrap-server localhost:9092 --partitions 2 --topic event
> kafka-topics.sh --create --bootstrap-server localhost:9092 --partitions 1 --topic market
```
# Running application
### Build Spring Boot project with Maven
```
> maven package
```
or you can also use
```
mvn install
```
### Run Spring Boot app with java -jar command
```
java -jar target/offerapp-0.0.1-SNAPSHOT.jar
```
### Run Spring Boot app using Maven
```
mvn spring-boot:run
