package com.assessment.web2.service;

import com.assessment.web2.entity.Employee;
import com.assessment.web2.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeeByPosition(String position) {
        return employeeRepository.findAllByPosition(position);
    }
}
