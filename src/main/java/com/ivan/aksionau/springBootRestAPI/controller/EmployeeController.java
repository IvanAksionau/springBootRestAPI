package com.ivan.aksionau.springBootRestAPI.controller;

import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @RequestMapping("/employee")
    public Employee getEmployee() {
        return Employee.builder()
                .id(1)
                .name("Ivan Aksionau")
                .email("ivan.aksionau@gmail.com")
                .phone(243242343)
                .address(Address.builder()
                        .street("123 Main St")
                        .city("New York")
                        .country("USA")
                        .build())
                .build();
    }
}
