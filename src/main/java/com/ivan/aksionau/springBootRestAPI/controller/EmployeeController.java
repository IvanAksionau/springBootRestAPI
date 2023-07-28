package com.ivan.aksionau.springBootRestAPI.controller;

import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.springBootRestAPI.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeesList();
    }

    @GetMapping(value = "/employee/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employeeById = employeeService.getEmployeeById(id);
        if (employeeById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeById);
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee employeeSaved = employeeService.addEmployee(employee);
        if (employeeSaved == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeSaved);
        }
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        try {
            Employee employeeSaved = employeeService.updateEmployee(id, employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeSaved);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
