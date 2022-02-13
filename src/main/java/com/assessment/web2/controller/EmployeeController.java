package com.assessment.web2.controller;

import com.assessment.web2.entity.Employee;
import com.assessment.web2.service.EmployeeService;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employee")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "employee";
    }

    @GetMapping(value = "/employee-filtered")
    public String getFilteredEmployees(Model model, @Validated @NotNull @RequestParam String position) {
        log.debug("Request received to serve filtered employees by position: {}", position);
        List<Employee> filteredEmployees = employeeService.getAllEmployeeByPosition(position);
        log.debug("Total employees: {}, under position: {}", filteredEmployees.size(), position);
        model.addAttribute("employees", filteredEmployees);
        return "employee";
    }
}
