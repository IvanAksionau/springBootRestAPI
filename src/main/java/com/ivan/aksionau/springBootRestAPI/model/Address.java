package com.ivan.aksionau.springBootRestAPI.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String city;
    private String country;
}
