package com.assessment.web2;

import com.assessment.web2.controller.EmployeeController;
import com.assessment.web2.entity.Employee;
import com.assessment.web2.repo.EmployeeRepository;
import com.assessment.web2.service.ApplicationUserDetailsService;
import com.assessment.web2.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @MockBean
    EmployeeService employeeService;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    EmployeeRepository employeeRepository;
    @MockBean
    ApplicationUserDetailsService applicationUserDetailsService;

    @Test
    public void getAllEmployees_accessForbidden() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employee")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void getAllEmployees_success() throws Exception {
        List<Employee> mockedEmployees = new ArrayList<>();
        mockedEmployees.add(new Employee(1, "Name 1", "Designation 1", "Position 1"));
        mockedEmployees.add(new Employee(2, "Name 2", "Designation 2", "Position 2"));
        mockedEmployees.add(new Employee(3, "Name 3", "Designation 3", "Position 3"));
        mockedEmployees.add(new Employee(4, "Name 4", "Designation 4", "Position 4"));
        Mockito.when(employeeRepository.findAll()).thenReturn(mockedEmployees);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/employee-filtered?position=Manager")
                .header("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwYXBwdSIsImV4cCI6MTY0NDc2MjUzNn0.Ns27vwUBCPLRW0aGts7DpgeHYnz4GuI0Q0C6kRg0QKoX-DoPBdwoEtSWU20w-qO-0hvRGBcubmx2_Df86heXUA")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
