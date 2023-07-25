package com.ivan.aksionau.springBootRestAPI.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.springBootRestAPI.utils.JsonDataManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private JsonDataManager manager;

    private Map<String, Object> convertObjectToMap(Employee employee) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .convertValue(employee, new TypeReference<Map<String, Object>>() {
                });
    }

    @Override
    public List<Employee> getEmployeesList() {
        return manager.getEmployeeList();
    }

    @Override
    public List<Employee> getEmployeesListByKeys(Map<String, String> queryParameters) {
        List<Employee> employeeList = new ArrayList<>();

        for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (isValidEmployeeAttribute(key)) {
                List<Employee> matchingEmployees = manager.getEmployeeList().stream()
                        .filter(emp -> matchesAttribute(emp, entry.getKey(), value))
                        .toList();

                employeeList.addAll(matchingEmployees);
            }
        }
        return employeeList;
    }

    private boolean isValidEmployeeAttribute(String attribute) {
        try {
            Employee.class.getDeclaredField(attribute);
        } catch (NoSuchFieldException e) {
            log.error("No such field: " + attribute);
            return false;
        }
        return true;
    }

    private boolean matchesAttribute(Employee employee, String attribute, String value) {
        Map<String, Object> employeeMap = convertObjectToMap(employee);
        return employeeMap.get(attribute).equals(value);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return manager.getEmployeeList().stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        manager.getEmployeeList().add(employee);
        return employee;
    }

    @Override
    public List<Employee> deleteEmployee(int id) {
        manager.getEmployeeList().removeIf(emp -> emp.getId() == id);
        return manager.getEmployeeList();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        getEmployeeById(id);
        return manager.getEmployeeList().stream().filter(emp -> emp.getId() == id).
                peek(emp -> {
                    emp.setName(employee.getName());
                    emp.setEmail(employee.getEmail());
                    emp.setPhone(employee.getPhone());
                    emp.setAddress(employee.getAddress());
                }).findFirst().orElse(null);
    }
}
