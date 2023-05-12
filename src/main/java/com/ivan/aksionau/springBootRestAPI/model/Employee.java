package com.ivan.aksionau.springBootRestAPI.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private int id;
    private String name;
    private Address address;
    private String email;
    private int phone;
}
