# ns-task
NSoft Tasks

# Running kafka in the docker container
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