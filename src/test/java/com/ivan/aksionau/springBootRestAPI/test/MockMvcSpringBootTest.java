package com.ivan.aksionau.springBootRestAPI.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.aksionau.springBootRestAPI.BaseConfiguration;
import com.ivan.aksionau.springBootRestAPI.bootstrap.DataInitializer;
import com.ivan.aksionau.springBootRestAPI.controller.EmployeeController;
import com.ivan.aksionau.springBootRestAPI.model.Address;
import com.ivan.aksionau.springBootRestAPI.model.Employee;
import com.ivan.aksionau.springBootRestAPI.repositories.EmployeeRepository;
import com.ivan.aksionau.springBootRestAPI.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

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
 * It will not start the embedded tomcat server itself,
 * it will test the {@link EmployeeController} class in isolation.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {EmployeeController.class, BaseConfiguration.class})
public class MockMvcSpringBootTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void initTestData() {
        context.getBean(DataInitializer.class).initEmployeeTestData();
    }

    @Test
    public void testGetEmployeeByID() throws Exception {
        // Arrange
        var employee = Employee.builder()
                .id(1L)
                .email("karthik@test.com")
                .name("Karthik")
                .phone(23423423)
                .address(Address.builder().city("Auckland").country("NZ").street("12 Street").build())
                .build();

        // Act
        when(employeeService.getEmployeeById(1L)).thenReturn(employee);

        // Assertion
        ResultActions resultActions = this.mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Employee response = objectMapper.readValue(contentAsString, Employee.class);
        assert response.equals(employee);
    }

    @Test
    public void testGetEmployee() throws Exception {
        // Arrange
        var employee = Employee.builder()
                .id(1L)
                .email("karthik@test.com")
                .name("Karthik")
                .phone(23423423)
                .address(Address.builder().city("Auckland").country("NZ").street("12 Street").build())
                .build();

        // Act
        when(employeeService.getEmployeeById(1L)).thenReturn(employee);

        // Assertion
        this.mockMvc.perform(get("/employee/1"))
                .andExpect(jsonPath("name").value("Karthik"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEmployees() throws Exception {
        // Arrange
        List<Employee> employees = employeeRepository.findAll();

        // Act
        when(employeeService.getEmployeesList()).thenReturn(employees);

        // Assertion
        var result = this.mockMvc.perform(get("/employees"))
                .andExpect(jsonPath("$[0].name").value("Ivan"))
                .andExpect(jsonPath("$[0].address.city").value("New York"))
                .andExpect(jsonPath("$[1].name").value("John Doe"))
                .andExpect(jsonPath("$[1].address.city").value("Los Angeles"))
                .andExpect(status().isOk());
    }
}
