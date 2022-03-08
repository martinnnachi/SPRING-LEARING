package com.martinnnachi.springdemo.controller;

import com.martinnnachi.springdemo.entity.Customer;
import com.martinnnachi.springdemo.service.CustomerService;
import com.martinnnachi.springdemo.util.SortUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String listCustomers(Model theModel, @RequestParam(required = false) String sort) {

        // get the customers from the service
       List<Customer> theCustomers = null;

       // check for sort field
        if (sort != null) {
            int theSortField = Integer.parseInt( sort );
            theCustomers = customerService.getCustomers(theSortField);
        }else {
            // no sort field provided ... default to sorting by last name
            theCustomers = customerService.getCustomers( SortUtils.LAST_NAME );
        }

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

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        // get the customer from our service
        Customer theCustomer = customerService.getCustomer( theId );

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute( "customer", theCustomer );

        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        // delete the customer
        customerService.deleteCustomer( theId );

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        List<Customer> theCustomers = customerService.searchCustomers( theSearchName );

        theModel.addAttribute( "customers", theCustomers );

        return "list-customers";
    }


}
