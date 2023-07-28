package com.ivan.aksionau.springBootRestAPI.steps;

import com.ivan.aksionau.springBootRestAPI.BaseConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * This class is used to configure Cucumber with Spring Boot.
 * <p>
 * The @CucumberContextConfiguration annotation is used to load the Spring Boot application context.
 * The @SpringBootTest annotation is used to load the application configuration.
 */
@CucumberContextConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(
        classes = CucumberTestContextConfig.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import({BaseConfiguration.class})
public class CucumberTestContextConfig {
}
