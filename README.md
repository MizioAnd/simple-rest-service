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

## When running service with input from .R file using rserve
Open a R session in RStudio and run the following commands in the console to start rserve

$ install.packages("Rserve")

$ library("Rserve")

$ Rserve(args = "--no-save")

This will allow the microservice to create an R connection and run R commands.
We still need to work a bit on exception handling such exceptions from R gets shown in the microservice json output instead of a status 500 "Internal Server Error". In case of calling an R script we would need something like,

$ Rserve(args = "--RS-source ~/script.R")

## When running service with input from .py file
A python file hello.py is located in src/test/resources/ in is used as input for ProcessBuilder.

The ProcessBuilder class provides methods for creating and configuring operating system processes. Each ProcessBuilder instance allows us to manage a collection of process attributes. We can then start a new Process with those given attributes. We can use the ProcessBuilder API to create a native operating system process to launch python and execute our simple script.

It has been tested exceptions from python are shown in json output instead of status 500 "Internal Server Error" in case of a python exception thrown inside the python script.