package com.martinnnachi.ecommerce.service;

import com.martinnnachi.ecommerce.dao.CustomerRepository;
import com.martinnnachi.ecommerce.dto.Purchase;
import com.martinnnachi.ecommerce.dto.PurchaseResponse;
import com.martinnnachi.ecommerce.entity.Customer;
import com.martinnnachi.ecommerce.entity.Order;
import com.martinnnachi.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from the dto
        Order order = purchase.getOrder();

        // generate tracking number;
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber( orderTrackingNumber );

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach( order::add );

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress( purchase.getBillingAddress() );
        order.setShippingAddress( purchase.getShippingAddress() );

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add( order );

        // save to the database
        customerRepository.save( customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}









