package com.mnnachi.springboot.thymeleafdemo.service;

import com.mnnachi.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee employee);

    void deleteById(int theId);
}
