package com.ivan.aksionau.test;

import com.ivan.aksionau.springBootRestAPI.model.Employee;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class ResAssuredTest extends BaseResAssuredTest {

    @Test
    public void testGetEmployee() {
        given().baseUri(baseUrl).port(Integer.parseInt(port))
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("id", hasItems(1, 1))
                .body("name", hasItems("Ivan Aksionau", "Ivan Aksionau"));
    }

    @Test
    public void testPostEmployee() {
        Employee em = Employee.builder()
                .id(1)
                .email("example@.com")
                .name("Ivan")
                .build();

        Employee employee =  given().baseUri(baseUrl).port(Integer.parseInt(port))
                .when()
                .basePath("/employee")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(em)
                .post()
                .body()
                .as(Employee.class);

        softAssert(
                () -> softly.assertThat(em).isEqualTo(employee),
                () -> softly.assertThat(em.getName())
                        .startsWith("Iv")
                        .endsWith("an")
                        .isEqualToIgnoringCase("Ivan"));
    }
}
