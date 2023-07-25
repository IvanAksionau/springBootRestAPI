package com.ivan.aksionau.springBootRestAPI.service;

import com.ivan.aksionau.springBootRestAPI.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getEmployeesList();

    List<Employee> getEmployeesListByKeys(Map<String, String> queryParameters);

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    List<Employee> deleteEmployee(int id);

    Employee updateEmployee(int id, Employee employee);
}
