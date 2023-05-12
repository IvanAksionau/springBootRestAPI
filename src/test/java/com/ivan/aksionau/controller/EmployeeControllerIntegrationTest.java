package com.ivan.aksionau.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(classes = EmployeeControllerIntegrationTest.class)
public class EmployeeControllerIntegrationTest {

    @Value("${app.url}")
    private String appUrl;

    @BeforeTestClass
    public void setUp() {
        RestAssured.baseURI = appUrl;
    }

    @Test
    public void testGetEmployee() {
        given()
                .when()
                .get("/employee")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Ivan Aksionau"))
                .body("email", equalTo("ivan.aksionau@gmail.com"))
                .body("phone", equalTo(243242343))
                .body("address.street", equalTo("123 Main St"))
                .body("address.city", equalTo("New York"))
                .body("address.country", equalTo("USA"));
    }
}
