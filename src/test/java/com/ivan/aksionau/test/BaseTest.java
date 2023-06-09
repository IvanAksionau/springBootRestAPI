package com.ivan.aksionau.test;

import com.ivan.aksionau.springBootRestAPI.BaseConfiguration;
import com.ivan.aksionau.springBootRestAPI.utils.JsonDataManager;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.function.Supplier;

@Slf4j
@Import(BaseConfiguration.class)
@SpringBootTest(classes = BaseTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    @Value("${base.url}")
    protected String baseUrl;

    @LocalServerPort
    protected String port;

    @Autowired
    protected JsonDataManager manager;

    protected SoftAssertions softly = new SoftAssertions();

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

    @AfterEach
    public void clearTestData() {
        manager.getEmployeeList().clear();
    }
}
