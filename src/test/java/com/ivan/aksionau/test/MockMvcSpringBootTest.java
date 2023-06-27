package com.ivan.aksionau.test;

import com.ivan.aksionau.BaseTestConfiguration;
import com.ivan.aksionau.springBootRestAPI.controller.EmployeeController;
import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.springBootRestAPI.service.EmployeeService;
import com.ivan.aksionau.utils.JsonReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * This class mocks the EmployeeController controller.
 * <p>
 * This test will not actually test the application, but will only test the one selected controller.
 * It will not start the embedded tomcat server itself, it will test the @EmployeeController class in isolation.
 */
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = {EmployeeController.class, BaseTestConfiguration.class})
//@Import(BaseTestConfiguration.class)
public class MockMvcSpringBootTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JsonReader reader;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeByID() throws Exception {
        // Arrange
        var employee = Employee.builder()
                .id(1)
                .email("karthik@test.com")
                .name("Karthik")
                .phone(23423423)
                .address(Address.builder().city("Auckland").country("NZ").street("12 Street").build())
                .build();

        // Act
        when(employeeService.getEmployeeById(1)).thenReturn(employee);

        // Assertion
        this.mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEmployee() throws Exception {
        // Arrange
        var employee = Employee.builder()
                .id(1)
                .email("karthik@test.com")
                .name("Karthik")
                .phone(23423423)
                .address(Address.builder().city("Auckland").country("NZ").street("12 Street").build())
                .build();

        // Act
        when(employeeService.getEmployeeById(1)).thenReturn(employee);

        // Assertion
        this.mockMvc.perform(get("/employee/1"))
                .andExpect(jsonPath("name").value("Karthik"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEmployees() throws Exception {
        // Arrange
        List<Employee> employees = reader.readEmployeeListFile();

        // Act
        when(employeeService.getEmployeesList()).thenReturn(employees);

        // Assertion
        var result = this.mockMvc.perform(get("/employees"))
                .andExpect(jsonPath("$[0].name").value("Ivan Aksionau"))
                .andExpect(jsonPath("$[0].address.city").value("New York"))
                .andExpect(jsonPath("$[1].name").value("John Doe"))
                .andExpect(jsonPath("$[1].address.city").value("Los Angeles"))
                .andExpect(status().isOk());
    }
}