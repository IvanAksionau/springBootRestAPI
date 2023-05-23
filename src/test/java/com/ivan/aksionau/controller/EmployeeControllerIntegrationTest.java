package com.ivan.aksionau.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeControllerIntegrationTest extends BaseTest {

    @Test
    public void testGetEmployee() {
        given()
                .when()
                .get("/employees")
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
