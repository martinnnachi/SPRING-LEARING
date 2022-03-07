package com.martinnnachi.springdemo.controller;

import com.martinnnachi.springdemo.dao.CustomerDAO;
import com.martinnnachi.springdemo.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	public final CustomerDAO customerDAO;

	public CustomerController(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		// get the customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();

		// add the customers to the model
		theModel.addAttribute( "customers", theCustomers );
		
		return "list-customers";
	}
	
}
