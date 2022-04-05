package com.mnnachi.springboot.thymeleafdemo.controller;

import com.mnnachi.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        // create employees
        Employee employee1 = new Employee( 1, "Martin", "Nnachi", "marty@nnach.com" );
        Employee employee2 = new Employee( 1, "Gloria", "Nnachi", "glo.amiya@nnach.com" );
        Employee employee3 = new Employee( 1, "Edinam", "Gbormittah", "edi.g@me.com" );

        // create a list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add( employee1 );
        theEmployees.add( employee2 );
        theEmployees.add( employee3 );
    }

    // add mapping for /list
    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute( "employees", theEmployees );

        return "list-employees";

    }

}
