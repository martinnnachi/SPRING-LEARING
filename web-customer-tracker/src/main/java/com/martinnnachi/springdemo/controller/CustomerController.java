package com.martinnnachi.springdemo.controller;

import com.martinnnachi.springdemo.entity.Customer;
import com.martinnnachi.springdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer service
    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get the customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute( "customers", theCustomers );

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Customer customer = new Customer();
        theModel.addAttribute( "customer", customer );
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer using our service
        customerService.saveCustomer( theCustomer );
        return "redirect:/customer/list";
    }

}
