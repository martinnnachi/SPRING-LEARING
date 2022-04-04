package com.martinnnachi.cruddemo.dao;


import com.martinnnachi.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee employee);

    void deleteById(int theId);

}
