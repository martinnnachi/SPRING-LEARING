package com.martinnnachi.ecommerce.dto;

import com.martinnnachi.ecommerce.entity.Address;
import com.martinnnachi.ecommerce.entity.Customer;
import com.martinnnachi.ecommerce.entity.Order;
import com.martinnnachi.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
