package com.ivan.aksionau.springBootRestAPI.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"address"})
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private String email;

    private int phone;
}
