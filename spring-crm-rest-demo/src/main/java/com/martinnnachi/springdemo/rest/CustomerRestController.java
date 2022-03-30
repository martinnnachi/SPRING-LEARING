package com.martinnnachi.springdemo.rest;

import com.martinnnachi.springdemo.entity.Customer;
import com.martinnnachi.springdemo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService
    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/home")
    public String homePage() {
        return "index";
    }


    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer theCustomer = customerService.getCustomer( customerId );

        if (theCustomer == null) {
            throw new CustomerNotFoundException( "Customer id not found: " + customerId );
        }

        return theCustomer;
    }

    // add mapping for POST /customers - add a new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        // also, just in case they pass an id in JSON ... set id to 0
        // this is to force a save of a new item ... instead of update
        theCustomer.setId( 0 );

        customerService.saveCustomer( theCustomer );


        return theCustomer;
    }

    // add mapping for PUT /customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer( theCustomer );

        return theCustomer;
    }

    // add mapping for DELETE /customers/{customerId} - delete customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer tempCostumer = customerService.getCustomer( customerId );

        if (tempCostumer == null) {
            throw new CustomerNotFoundException( "No such customer: " + customerId );
        }
        customerService.deleteCustomer( customerId );

        return "Deleted customer id: " + customerId;
    }


}
