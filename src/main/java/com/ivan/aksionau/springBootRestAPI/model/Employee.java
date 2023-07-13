package com.ivan.aksionau.springBootRestAPI.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Setter(AccessLevel.PROTECTED)
@ToString(exclude = {"address"})
@EqualsAndHashCode
public class Employee {
    private @NonNull int id;
    private String name;
    private Address address;
    private String email;
    private int phone;
}
