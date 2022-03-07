package com.martinnnachi.springdemo.dao;

import com.martinnnachi.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}
