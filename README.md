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

In case of error msg like,
"java.net.ConnectException: Connection refused (Connection refused)"
"org.rosuda.REngine.Rserve.RConnection.<init>(RConnection.java:85)"

Jump to section for Rserve since it needs to run in order for java to create a RConnection.

## When running service with input from .R file using rserve
Open a R session in RStudio and run the following commands in the console to start rserve

$ install.packages("Rserve")

$ library("Rserve")

$ Rserve(args = "--no-save")

Or just start an R session from terminal and run
$ install.packages("Rserve");library("Rserve");Rserve(args = "--no-save");

This will allow the microservice to create an R connection and run R commands.
We still need to work a bit on exception handling such exceptions from R gets shown in the microservice json output instead of a status 500 "Internal Server Error". In case of calling an R script we would need something like,

$ Rserve(args = "--RS-source ~/script.R")

## When running service with input from .py file
A python file hello.py is located in src/test/resources/ in is used as input for ProcessBuilder.

The python scripts imports a method from a custom python pkg example-pkg-mizioand. Therefore we need to first install that package into our local environment. Now assuming the local virtual env is already activated run this cmd, 

$ python3 -m pip install --no-deps example-pkg-mizioand-0.0.1.tar.gz

More instructions on how the custom python pkg was made can be found here,

https://github.com/MizioAnd/python-pkg-template

The Java ProcessBuilder class provides methods for creating and configuring operating system processes. Each ProcessBuilder instance allows us to manage a collection of process attributes. We can then start a new Process with those given attributes. We can use the ProcessBuilder API to create a native operating system process to launch python and execute our simple script.

It has been tested exceptions from python are shown in json output instead of status 500 "Internal Server Error" in case of a python exception thrown inside the python script.