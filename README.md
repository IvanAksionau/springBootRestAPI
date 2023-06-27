# Simple example of Spring Boot based REST API application.

### APP preconditions
* start app by running SpringBootRestApiApplication class
* access APP on http://localhost:8080/
* 
### tests preconditions
* any class extending BaseResAssuredTest class can be executed without APP preconditions

### Error handling (Web application could not be started as there.....server.ServletWebServerFactory bean defined in the context.)
*  mvn dependency:purge-local-repository -DreResolve=true
* mvn package -DskipTests
