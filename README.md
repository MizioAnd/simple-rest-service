# simple-rest-service

run service,

$ ./mvnw spring-boot:run

or build jar file with,

$ ./mvnw clean package

and then run it with,
$ java -jar target/rest-service-0.0.1-SNAPSHOT.jar &


Test running service with GET requests,

$ curl http://localhost:8080/greeting | jq '.'

$ curl http://localhost:8080/greeting?name=Superman | jq '.'