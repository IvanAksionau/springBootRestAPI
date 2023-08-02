package com.ivan.aksionau.springBootRestAPI.test;

import com.ivan.aksionau.springBootRestAPI.BaseConfiguration;
import com.ivan.aksionau.springBootRestAPI.bootstrap.DataInitializer;
import io.restassured.RestAssured;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * By default, @SpringBootTest will configure an in-memory embedded database,
 * scan for @Entity classes and configure Spring Data JPA repositories.
 * {@code @AutoConfigureTestDatabase} annotation can be used to override these settings.
 */
@Slf4j
@Import(BaseConfiguration.class)
//@ActiveProfiles("sql")
//@ComponentScan(basePackages = {"com/ivan/aksionau/bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = BaseTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    @Value("${base.url}")
    protected String baseUrl;

    @LocalServerPort
    protected String port;

    protected SoftAssertions softly = new SoftAssertions();

    @Autowired
    private DataInitializer dataInitializer;

    @PostConstruct
    public void init() {
        RestAssured.baseURI = baseUrl + ":" + port;
        log.info("Base URI: {}", RestAssured.baseURI);
    }

    @SafeVarargs
    protected final void softAssert(Supplier<? extends AbstractAssert<?, ?>>... assertionConsumer) {
        Arrays.stream(assertionConsumer).forEach(Supplier::get);
        softly.assertAll();
    }

    @BeforeEach
    public void initTestData() {
        dataInitializer.initEmployeeTestData();
    }
}
