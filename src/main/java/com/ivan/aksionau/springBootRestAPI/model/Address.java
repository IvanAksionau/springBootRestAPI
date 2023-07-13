package com.ivan.aksionau.springBootRestAPI.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String country;
}
