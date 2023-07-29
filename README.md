# Spring Boot based REST API test framework.

[![CI build state](https://github.com/IvanAksionau/springBootRestAPI/actions/workflows/ci_settings.yml/badge.svg)](https://github.com/IvanAksionau/springBootRestAPI/actions/workflows/ci_settings.yml)

[![img_4.png](img_4.png)](https://ivanaksionau.github.io/springBootRestAPI/overview-features.html)

### APP start
- To start APP based on embedded h2 database storage run command ```mvn spring-boot:run```
- To start APP based on MySQL storage run command ```mvn spring-boot:run -D"spring-boot.run.profiles=local"```
* Access APP on http://localhost:8080/

### Tests start
* Run command ```mvn verify``` and it will start cucumber tests based on H2 embedded storage and generate cucumber test report.
* In order to run tests based on MySQL storage - add env variable ```spring.profiles.active=sql``` .

### Allure report installation:
* https://github.com/ScoopInstaller/Install#for-admin ('.\install.ps1 -RunAsAdmin' in my case works)
* https://docs.qameta.io/allure/
- to start allure run 'allure serve target/allure-results/' from project root folder.


### Useful links:
- Lombok https://www.toptal.com/java/write-fat-free-java-code-project-lombok
- Spring Data JPA https://www.geeksforgeeks.org/spring-boot-spring-data-jpa/
- Testing the Web Layer with Spring https://spring.io/guides/gs/testing-web/
- Hamcrest tutorial https://www.vogella.com/tutorials/Hamcrest/article.html
- Cucumber docs https://cucumber.io/docs/cucumber/
- Cucumber with Spring https://thepracticaldeveloper.com/cucumber-tests-spring-boot-dependency-injection/