package com.ivan.aksionau.controller;

import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest(classes = BaseTest.class)
//@EnableAutoConfiguration
//@SpringBootTest(classes = BaseTest.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class  BaseTest {

    @Value("${app.url}")
    protected String appUrl;

    @BeforeTestClass
    public void setUp() {
        RestAssured.baseURI = appUrl;
    }
}
