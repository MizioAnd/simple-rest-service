print("Hello Python here")

# Test that pyexception is thrown.
# Microservice output shows python exception in json when
# $ curl http://localhost:8080/greeting | jq '.'
#  /src/test/resources/hello.py\", line 3, in <module>,     import syds, ImportError: No module named syds
import syds