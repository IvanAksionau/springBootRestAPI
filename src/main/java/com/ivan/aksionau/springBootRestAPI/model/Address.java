package com.ivan.aksionau.springBootRestAPI.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address {
    private String street;
    private String city;
    private String country;
}
