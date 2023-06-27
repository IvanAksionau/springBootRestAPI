package com.ivan.aksionau.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonReader {

    @Value("${employee.list.file.path}")
    private String employeeListFilePath;

    @Value("${newEmployee.list.file.path}")
    private String newEmployeeListFilePath;

    private ObjectMapper mapper;

    @PostConstruct
    private void initialize() {
        mapper = new ObjectMapper();
    }

    public List<Employee> readEmployeeListFile() {
        List<Employee> employeeList = null;

        try {
            // Read JSON file and map it to a list of objects
            employeeList = mapper.readValue(
                    new File(employeeListFilePath),
                    new TypeReference<>() {
                    }
            );
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
