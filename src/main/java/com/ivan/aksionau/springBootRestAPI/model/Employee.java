package com.ivan.aksionau.springBootRestAPI.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"address"})
public class Employee {
    private int id;
    private String name;
    private Address address;
    private String email;
    private int phone;
}
