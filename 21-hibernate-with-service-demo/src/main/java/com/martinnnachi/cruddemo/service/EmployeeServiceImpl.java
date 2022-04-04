package com.martinnnachi.cruddemo.service;

import com.martinnnachi.cruddemo.dao.EmployeeDao;
import com.martinnnachi.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDao.findById( theId );
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save( employee );

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDao.deleteById( theId );
    }
}
