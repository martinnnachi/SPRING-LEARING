package com.martinnnachi.cruddemo.rest;

import com.martinnnachi.cruddemo.entity.Employee;
import com.martinnnachi.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private final EmployeeService employeeService;

    // inject employee service
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // get employee by given id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById( employeeId );

        if (employee == null) {
            throw new RuntimeException( "Employee id not found: " + employeeId );
        }

        return employee;
    }

    // add/create a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // set id to zero in case they pass an id in JSON
        // this is to force a save of a new item...instead of update
        employee.setId( 0 );
        employeeService.save( employee );

        return employee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save( employee );

        return employee;
    }

    // add mapping for DELETE /employees/employeeId

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById( employeeId );

        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException( "Employee id not found: " + employeeId );
        }
        employeeService.deleteById( employeeId );

        return "Deleted employee id: " + employeeId;
    }
}
