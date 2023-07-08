package com.ivan.aksionau.test;

import com.ivan.aksionau.springBootRestAPI.controller.EmployeeController;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

/**
 * This class is used to test {@link EmployeeController} class using RestAssured.
 * <p>
 * This test will automatically start the application on a random port and
 * send the request to the controller.
 */
@Slf4j
public class EmployeeControllerIntegrationTest extends BaseTest {

    @Test
    public void testGetEmployees() {
        given()
                .when()
                .get("/employees")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", hasItems(1, 1))
                .body("name", hasItems("Ivan Aksionau", "Ivan Aksionau"));
    }

    @Test
    public void testGetEmployById() {
        given()
                .with().pathParam("id", 1)
                .when()
                .get("/employee/{id}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", equalTo(1));

        Employee employee = given()
                .with().pathParam("id", 1)
                .when()
                .get("/employee/{id}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Employee.class);

        assertThat(employee.getId(), equalTo(1));
    }

    @Test
    public void testGetEmployeeListByParameters() {
        Employee[] employee = given()
                .queryParam("nam5e", "Ivan Aksionau")
                .queryParam("email", "john.doe@example.com")
                .when()
                .get("/employeesQueried")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Employee[].class);

        System.out.println(employee[0].toString());
//        assertThat(employee.getId(), equalTo(1));
    }
}
