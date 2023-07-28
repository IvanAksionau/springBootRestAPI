package com.ivan.aksionau.springBootRestAPI.service;

import com.ivan.aksionau.springBootRestAPI.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeesList();

    Employee getEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
