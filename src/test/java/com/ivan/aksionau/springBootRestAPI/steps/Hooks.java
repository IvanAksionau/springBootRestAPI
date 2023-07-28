package com.ivan.aksionau.springBootRestAPI.steps;

import com.ivan.aksionau.springBootRestAPI.bootstrap.DataInitializer;
import com.ivan.aksionau.springBootRestAPI.repositories.EmployeeRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DataInitializer dataInitializer;

    @Before
    public void initTestData(Scenario scenario) {
        dataInitializer.initEmployeeTestData();
    }

//    @After
//    public void clearTestData(Scenario scenario) {
//        repository.deleteAll();
//    }
}
