package com.assessment.web2.service;

import com.assessment.web2.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeByPosition(String position);
}
