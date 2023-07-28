package com.ivan.aksionau.springBootRestAPI.bootstrap;

import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.springBootRestAPI.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        initEmployeeTestData();
    }

    public void initEmployeeTestData() {
        employeeRepository.deleteAll();

        employeeRepository.save(Employee.builder()
                .email("ivan@test.com")
                .name("Ivan")
                .phone(23423423)
                .address(Address.builder()
                        .city("New York")
                        .country("NZ")
                        .street("12 Street")
                        .build())
                .build());

        employeeRepository.save(Employee.builder()
                .email("karthik@test.com")
                .name("John Doe")
                .phone(23423423)
                .address(Address.builder()
                        .city("Los Angeles")
                        .country("NZ")
                        .street("12 Street")
                        .build())
                .build());
    }
}
