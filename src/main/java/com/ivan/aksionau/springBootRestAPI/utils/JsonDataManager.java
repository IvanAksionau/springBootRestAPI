package com.ivan.aksionau.springBootRestAPI.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Profile({"data"})
@Slf4j
@Component
public class JsonDataManager {

    @Value("${JAVA_HOME}")
    private String javaHomeVariable;

    @Value("${employee.list.file.path}")
    private String employeeListFilePath;

    @Value("${newEmployee.list.file.path}")
    private String newEmployeeListFilePath;

    @Autowired
    private ObjectMapper mapper;

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        if (employeeList == null || employeeList.isEmpty()) {
            employeeList = readEmployeeListFile();
        }
        return employeeList;
    }

    public void clearEmployeeList() {
        employeeList.clear();
        log.info("The list of employees has been cleared.");
    }

    private List<Employee> readEmployeeListFile() {
        List<Employee> employeeList = null;
        try {
            // Read JSON file and map it to a list of objects
            employeeList = mapper.readValue(
                    new File(employeeListFilePath),
                    new TypeReference<>() {
                    }
            );
            log.info("EmployeeList was initialized within: {}", employeeList.size() + " employees.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void writeEmployeeListFile(List<Employee> employeesList) {
        try {
            // Convert employeesList to JSON and write it to a file
            mapper.writeValue(new File(newEmployeeListFilePath), employeesList);
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
