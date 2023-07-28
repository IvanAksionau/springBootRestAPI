package com.ivan.aksionau.springBootRestAPI.test;

import com.ivan.aksionau.springBootRestAPI.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MySQLIntegrationTest extends BaseTest {

    @Autowired
    EmployeeRepository bookRepository;

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }
}
