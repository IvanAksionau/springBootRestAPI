package com.ivan.aksionau.test;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.function.Supplier;

@Import(com.ivan.aksionau.springBootRestAPI.BaseConfiguration.class)
@SpringBootTest(classes = BaseResAssuredTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseResAssuredTest {

    @Value("${base.url}")
    protected String baseUrl;

    @LocalServerPort
    protected String port;

    protected SoftAssertions softly = new SoftAssertions();

    @SafeVarargs
    protected final void softAssert(Supplier<? extends AbstractAssert<?, ?>>... assertionConsumer) {
        Arrays.stream(assertionConsumer).toList().forEach(Supplier::get);
        softly.assertAll();
    }
}
