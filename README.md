# Example of Spring Boot based REST API application.

[![CI build state](https://github.com/IvanAksionau/springBootRestAPI/actions/workflows/ci_settings.yml/badge.svg)](https://github.com/IvanAksionau/springBootRestAPI/actions/workflows/ci_settings.yml)

### APP preconditions
* Start app by running SpringBootRestApiApplication class
* Access APP on http://localhost:8080/


### Tests preconditions
* Any class extending BaseTest class can be executed without APP preconditions


### Error handling (Web application could not be started as there.....server.ServletWebServerFactory bean defined in the context.)
* mvn dependency:purge-local-repository -DreResolve=true
* mvn package -DskipTests


### Useful links:
- Testing the Web Layer with Spring https://spring.io/guides/gs/testing-web/
- Hamcrest tutorial https://www.vogella.com/tutorials/Hamcrest/article.html