package com.ivan.aksionau.springBootRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Address address;
    private String email;
    private int phone;
}
