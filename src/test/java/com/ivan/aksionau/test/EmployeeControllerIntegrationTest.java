package com.ivan.aksionau.test;

import com.ivan.aksionau.springBootRestAPI.controller.EmployeeController;
import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

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
        //arrange
        List<Employee> employeeExpectedList = manager.getEmployeeList();

        //act
        Employee[] employees = given()
                .queryParam("name", "Ivan Aksionau")
                .queryParam("email", "john.doe@example.com")
                .when()
                .get("/employeesQueried")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Employee[].class);

        //assert
        assertThat(Lists.newArrayList(employees), equalTo(employeeExpectedList));
    }

    @Test
    public void testUpdateEmployee() {
        //arrange
        Employee updatedEmployee = Employee.builder()
                .id(1)
                .name("Ivan Aksionau")
                .email("ivan.aksionau@gmail.com")
                .address(new Address("333 Main St", "London", "EU")).build();
        //act
        Employee employee = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .with().pathParam("id", 1)
                .body(updatedEmployee)
                .when()
                .put("/employee/{id}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Employee.class);

        //assert
        assertThat(employee, equalTo(updatedEmployee));
    }
}
