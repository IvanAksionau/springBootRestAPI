package com.ivan.aksionau.springBootRestAPI.controller;

import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.springBootRestAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeesList();
    }

    @GetMapping("/employeesQueried")
    public List<Employee> getEmployeeListByParameters(@Validated @RequestParam Map<String, String> queryParameters) {
        return employeeService.getEmployeesListByKeys(queryParameters);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }
}
