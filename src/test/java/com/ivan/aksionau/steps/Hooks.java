package com.ivan.aksionau.steps;

import com.ivan.aksionau.springBootRestAPI.utils.JsonDataManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    protected JsonDataManager manager;

    @Before
    public void initTestData(Scenario scenario) {
        manager.getEmployeeList();
    }

    @After
    public void clearTestData(Scenario scenario) {
        manager.clearEmployeeList();
    }
}
