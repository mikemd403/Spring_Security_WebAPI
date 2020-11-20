# Calculator-REST-Webservice with Web API Security

### Student
Mike Diep 8334439

There are two roles in the application - user and admin. To learn how to run please go to section "To Use" below.

User role has permission to add and subtract.

User's Username: user

User's Password: userpass

Admin role has permission to add, subtract, multiply and divide.

Admin's Username: admin

Admin's Password: adminpass

### To Run
In the root project folder in a terminal run:

gradle wrapper

This will build and install all necessary jar wrappers. After run:

./gradlew bootRun

This will start the web service.

### To Use
The application was tested using Postman to make requests, therefore, below are instructions for Postman.

The requests must use method GET, and Authorization of Type Basic Auth. Enter a Username and Password.

Send a request using appropriate uri, example is seen below for subtract. Then press Send.

http://localhost:8080/calculator/subtract/125/3

### Documentation
The documentation can be found via

URL-JSON:  http://localhost:8080/v3/api-docs/

YAML: http://localhost:8080/v3/apidocs.yaml

Swagger UI: http://localhost:8080/swagger-ui.html