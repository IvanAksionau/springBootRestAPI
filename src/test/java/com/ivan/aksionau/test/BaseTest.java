package com.ivan.aksionau.test;

import com.ivan.aksionau.springBootRestAPI.BaseConfiguration;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.function.Supplier;

@Import(BaseConfiguration.class)
@SpringBootTest(classes = BaseTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    @Value("${base.url}")
    protected String baseUrl;

    @LocalServerPort
    protected String port;

    protected SoftAssertions softly = new SoftAssertions();

    @SafeVarargs
    protected final void softAssert(Supplier<? extends AbstractAssert<?, ?>>... assertionConsumer) {
        Arrays.stream(assertionConsumer).forEach(Supplier::get);
        softly.assertAll();
    }
}
