package com.ivan.aksionau.springBootRestAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @RequestMapping("/employee")
    public String welcome() {
        return "Welcome to Employee Page!";
    }
}
