package com.ivan.aksionau.test;

import com.ivan.aksionau.springBootRestAPI.controller.EmployeeController;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

/**
 * <p>
 * This class is used to test {@link EmployeeController} class using RestAssured.
 * <p>
 * This test will automatically start the application on a random port and
 * send the request to the controller.
 */
public class EmployeeControllerIntegrationTest extends BaseTest {

    @Test
    public void testGetEmployee() {
        RestAssured.baseURI = baseUrl + ":" + port;

        given()
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("id", hasItems(1, 1))
                .body("name", hasItems("Ivan Aksionau", "Ivan Aksionau"));
    }
}
