package com.assessment.web2.repo;

import com.assessment.web2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();
    List<Employee> findAllByPosition(@Param("position") String position);
}