# Example of Spring Boot based REST API application.

[![CI build state](https://github.com/IvanAksionau/springBootRestAPI/actions/workflows/ci_settings.yml/badge.svg)](https://github.com/IvanAksionau/springBootRestAPI/actions/workflows/ci_settings.yml)

[![img_4.png](img_4.png)](https://ivanaksionau.github.io/springBootRestAPI/overview-features.html)

### APP preconditions
* Start app by running SpringBootRestApiApplication class.
* Access APP on http://localhost:8080/


### Tests preconditions
* Any class extending BaseTest class can be executed without APP preconditions.

### Allure report installation:
* https://github.com/ScoopInstaller/Install#for-admin ('.\install.ps1 -RunAsAdmin' in my case works)
* https://docs.qameta.io/allure/
- to start allure run 'allure serve target/allure-results/' from project root folder.


### Useful links:
- Lombok https://www.toptal.com/java/write-fat-free-java-code-project-lombok
- Testing the Web Layer with Spring https://spring.io/guides/gs/testing-web/
- Hamcrest tutorial https://www.vogella.com/tutorials/Hamcrest/article.html
- Cucumber docs https://cucumber.io/docs/cucumber/
- Cucumber with Spring https://thepracticaldeveloper.com/cucumber-tests-spring-boot-dependency-injection/