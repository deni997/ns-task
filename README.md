# ns-task
NSoft Tasks

# Running kafka in the docker container
```
> docker-compose up -d
> docker-compose up
```

Update application.yml kafka bootstrap server to port 9093:
```
producer:
    bootstrap-servers:
        - localhost:9093
consumer:
    bootstrap-servers:
        - localhost:9093
```

### Kowl
Access kowl at:
http://localhost:8080

### Create new kafka topic directly in docker container
```
> docker exec -it kafka /bin/sh
> cd opt/bitnami/kafka/bin
> kafka-topics.sh --create --topi test_topic --bootstrap-server localhost:9092