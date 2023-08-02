package com.ivan.aksionau.springBootRestAPI.test;

import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * This class is used to end-to-end test APP using RestAssured.
 * <p>
 * This test will automatically start the application on a random port and
 * send the request to the controller.
 */
public class EmployeeControllerIntegrationTest extends BaseTest {

    @Test
    public void testGetEmployees() {
        Employee[] employees = given()
                .when()
                .get("/employees")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Employee[].class);

        assertThat(employees.length, equalTo(2));
    }

    @Test
    public void testAddEmployee() {
        //arrange
        Employee updatedEmployee = Employee.builder()
                .name("Ivan Aksionau")
                .email("ivan.aksionau@gmail.com")
                .address(Address.builder()
                        .street("333 Main St")
                        .city("London")
                        .country("EU")
                        .build())
                .build();
        //act
        Employee employee = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(updatedEmployee)
                .when()
                .post("/employee")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract().as(Employee.class);

        //assert
        assertThat(employee, equalTo(updatedEmployee));
    }

    @Test
    public void testUpdateEmployee() {
        //arrange
        Employee data = Employee.builder()
                .name("Ivan Aksionau")
                .email("ivan.aksionau@gmail.com")
                .address(Address.builder()
                        .street("333 Main St")
                        .city("London")
                        .country("EU")
                        .build())
                .build();

        Employee createdEmployee = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(data)
                .when()
                .post("/employee")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract().as(Employee.class);

        String newName = "Some other name";
        createdEmployee.setName(newName);

        //act
        Employee updatedEmployee = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .with().pathParam("id", createdEmployee.getId())
                .body(createdEmployee)
                .when()
                .put("/employee/{id}")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract().as(Employee.class);

        //assert
        assertThat(updatedEmployee, equalTo(createdEmployee));
    }
}
