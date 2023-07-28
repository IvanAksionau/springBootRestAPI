package com.ivan.aksionau.springBootRestAPI.steps;

import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableDefinition {

    @DataTableType(replaceWithEmptyString = "[anonymous]")
    public Employee employeeEntryTransformer(Map<String, String> row) {
        return new Employee(
                null,
                row.get("name"),
                new Address(null,
                        row.get("address.street"),
                        row.get("address.city"),
                        row.get("address.country")),
                row.get("email"),
                Integer.parseInt(row.get("phone"))
        );
    }
}
