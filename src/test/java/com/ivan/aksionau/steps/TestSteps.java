package com.ivan.aksionau.steps;

import com.ivan.aksionau.BaseTestConfiguration;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.utils.RestAssuredClient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
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

@Import(BaseTestConfiguration.class)
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
    @Step("I get the list of employees")
    public void i_get_the_list_of_employees() {
        response = restAssuredClient.get("/employees");
    }

    @Then("^I check the employee id and name with id (\\d+) and name \"([^\"]*)\"$")
    @Step("I check the employee id and name with id **** and name ****")
    public void i_check_the_employee_id_and_name(int id, String name) {
        ArrayList<Employee> employees = Lists.newArrayList(response.body().as(Employee[].class));
        softAssert(
                () -> softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value()),
                () -> softly.assertThat(employees.get(0).getId()).isEqualTo(id),
                () -> softly.assertThat(employees.get(0).getName()).isEqualTo(name));
    }

    @When("I update the employee by id {int}")
    @Step("I update the employee by id")
    public void i_update_the_employee_by_id(int id, Employee employee) {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("id", String.valueOf(id));
        response = restAssuredClient.put("/employee/{id}", parameters, employee);
    }

    @When("I add new employee")
    @Step("I add new employee")
    public void i_add_new_employee(Employee employee) {
        response = restAssuredClient.post("/employee", employee);
    }

    @Then("I check the employee exists")
    @Step("I check the employee exists")
    public void i_check_the_employee_exists(Employee employee) {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("id", String.valueOf(employee.getId()));
        response = restAssuredClient.getWithPathParameters("/employee/{id}", parameters);
        assertThat(response.body().as(Employee.class), equalTo(employee));
    }
}
