package com.ivan.aksionau.utils.client;

import com.ivan.aksionau.springBootRestAPI.model.Employee;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class RestAssuredClient {

    private RequestSpecification spec;

    @Value("${base.url}")
    private String baseUrl;

    @LocalServerPort
    private int port;

    @PostConstruct
    public void initRequestSpecification() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUrl + ":" + port);
        builder.setContentType(MediaType.APPLICATION_JSON_VALUE);

        RequestSpecification requestSpecification = builder.build();
        spec = RestAssured.given().spec(requestSpecification);
    }

    public Response getWithPathParameters(String url, Map<String, String> parameters) {
        spec.pathParams(parameters);
        return get(url);
    }

    public Response get(String url) {
        return spec.get(url);
    }

    public Response put(String url, Map<String, String> parameters, Employee employee) {
        spec.pathParams(parameters);
        spec.body(employee);
        return spec.put(url);
    }

    public Response post(String url, Employee employee) {
        spec.body(employee);
        return spec.post(url);
    }
}
