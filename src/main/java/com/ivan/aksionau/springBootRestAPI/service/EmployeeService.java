package com.ivan.aksionau.springBootRestAPI.service;

import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private static final ArrayList<Employee> employeesList = new ArrayList<>(Arrays.asList(
            Employee.builder()
                    .id(1)
                    .name("Ivan Aksionau")
                    .email("ivan.aksionau@gmail.com")
                    .phone(243242343)
                    .address(Address.builder()
                            .street("123 Main St")
                            .city("New York")
                            .country("USA")
                            .build())
                    .build(),
            Employee.builder()
                    .id(1)
                    .name("Ivan Aksionau")
                    .email("ivan.aksionau@gmail.com")
                    .phone(243242343)
                    .address(Address.builder()
                            .street("123 Main St")
                            .city("New York")
                            .country("USA")
                            .build())
                    .build()
    ));

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public Employee getEmployeeById(int id) {
        return getEmployeesList().stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    public Employee addEmployee(Employee employee) {
        employeesList.add(employee);
        return employee;
    }

    public ArrayList<Employee> deleteEmployee(int id) {
        employeesList.removeIf(emp -> emp.getId() == id);
        return employeesList;
    }

    public Employee updateEmployee(int id, Employee employee) {
        getEmployeeById(id);
        return getEmployeesList().stream().filter(emp -> emp.getId() == id).
                peek(emp -> {
                    emp.setName(employee.getName());
                    emp.setEmail(employee.getEmail());
                    emp.setPhone(employee.getPhone());
                    emp.setAddress(employee.getAddress());
                }).findFirst().orElse(null);
    }
}
