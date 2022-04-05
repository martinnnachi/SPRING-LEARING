package com.martinnnachi.cruddemo.service;

import com.martinnnachi.cruddemo.dao.EmployeeRepository;
import com.martinnnachi.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById( theId );

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException( "Did not find employee id: " + theId );
        }
        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save( employee );

    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById( theId );
    }
}
