package com.martinnnachi.cruddemo.dao;

import com.martinnnachi.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    
}
