package com.ivan.aksionau.test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class EmployeeControllerIntegrationTest extends BaseTest {

    @Test
    public void testGetEmployee() {
        given()
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("id", hasItems(1, 1))
                .body("name", hasItems("Ivan Aksionau", "Ivan Aksionau"));
    }
}
