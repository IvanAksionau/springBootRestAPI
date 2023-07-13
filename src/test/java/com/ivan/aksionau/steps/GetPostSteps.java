package com.ivan.aksionau.steps;

import com.ivan.aksionau.BaseTestConfiguration;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.utils.RestAssuredExtension;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@Import(BaseTestConfiguration.class)
public class GetPostSteps {

    private static Response response;
    private final SoftAssertions softly = new SoftAssertions();

    @Autowired
    private RestAssuredExtension extension;

    @When("I get the list of employees")
    public void i_get_the_list_of_users() {
        response = extension.get("/employees");
    }

    @Then("^I check the user id and name with id (\\d+) and name \"([^\"]*)\"$")
    public void i_check_the_user_id_and_name(int id, String name) {
        ArrayList<Employee> employees = Lists.newArrayList(response.body().as(Employee[].class));
        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value());
        softly.assertThat(employees.get(0).getId()).isEqualTo(id);
        softly.assertThat(employees.get(0).getName()).isEqualTo(name);
        softly.assertAll();
    }
}
