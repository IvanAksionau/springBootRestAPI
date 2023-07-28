package com.ivan.aksionau.springBootRestAPI.steps;

import com.ivan.aksionau.springBootRestAPI.BaseConfiguration;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.springBootRestAPI.utils.RestAssuredClient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Import(BaseConfiguration.class)
public class TestSteps {

    private final SoftAssertions softly = new SoftAssertions();
    @Autowired
    private RestAssuredClient restAssuredClient;
    private Response response;

    @SafeVarargs
    private void softAssert(Supplier<? extends AbstractAssert<?, ?>>... assertionConsumer) {
        Arrays.stream(assertionConsumer).forEach(Supplier::get);
        softly.assertAll();
    }

    @When("I get the list of employees")
    public void i_get_the_list_of_employees() {
        response = restAssuredClient.get("/employees");
    }

//    @Then("^I check the employee id and name with id (\\d+) and name \"([^\"]*)\"$")
    @Then("^I check the employee with name \"([^\"]*)\" exists")
    public void i_check_the_employee_with_name_exists(String name) {
        ArrayList<Employee> employees =
                Lists.newArrayList((Employee[]) parseResponseAsEntity(response, Employee[].class));
        softAssert(
                () -> softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value()),
                () -> softly.assertThat(employees.get(0).getName()).isEqualTo(name));
    }

    @When("I update the employee by id {int}")
    public void i_update_the_employee_by_id(int id, Employee employee) {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("id", String.valueOf(id));
        response = restAssuredClient.put("/employee/{id}", parameters, employee);
    }

    @When("I add new employee")
    public void i_add_new_employee(Employee employee) {
        response = restAssuredClient.post("/employee", employee);
    }

    @Then("I check the employee exists")
    public void i_check_the_employee_exists(Employee employee) {
        Employee empResponse = (Employee) parseResponseAsEntity(response, Employee.class);
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("id", String.valueOf(empResponse.getId()));
        response = restAssuredClient.getWithPathParameters("/employee/{id}", parameters);
        assertThat((Employee) parseResponseAsEntity(response, Employee.class), equalTo(employee));
    }

    private Object parseResponseAsEntity(Response response, Class<?> cls) {
        Object o;
        try {
            o = response.body().as(cls);
        } catch (IllegalStateException e) {
            throw new AssertionError(
                    "Response body isn't a valid JSON with status code "
                            + response.getStatusCode(), e);
        }
        return o;
    }
}
