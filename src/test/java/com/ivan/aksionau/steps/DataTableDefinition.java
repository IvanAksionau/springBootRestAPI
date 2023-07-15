package com.ivan.aksionau.steps;

import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableDefinition {

    @DataTableType(replaceWithEmptyString = "[anonymous]")
    public Employee employeeEntryTransformer(Map<String, String> row) {
        return new Employee(
                Integer.parseInt(row.get("id")),
                row.get("name"),
                new Address(
                        row.get("address.street"),
                        row.get("address.city"),
                        row.get("address.country")),
                row.get("email"),
                Integer.parseInt(row.get("phone"))
        );
    }
}
