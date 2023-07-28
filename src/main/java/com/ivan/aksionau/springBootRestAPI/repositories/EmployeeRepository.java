package com.ivan.aksionau.springBootRestAPI.repositories;

import com.ivan.aksionau.springBootRestAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
