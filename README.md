# Consumer Producer

Spring Kafka consumer-producer sample

### Running

Before running the system you must run the kafka service. Just run the command below to initialize kafka docker.

```
docker-compose up -d
```

Then, run the producer and the consumer.

```
cd producer
mvn spring-boot:run
cd consumer
mvn spring-boot:run
```
