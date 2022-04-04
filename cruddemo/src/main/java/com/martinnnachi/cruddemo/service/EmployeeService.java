package com.martinnnachi.cruddemo.service;

import com.martinnnachi.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee employee);

    void deleteById(int theId);
}
