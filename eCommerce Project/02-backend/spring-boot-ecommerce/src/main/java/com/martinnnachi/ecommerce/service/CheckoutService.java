package com.martinnnachi.ecommerce.service;


import com.martinnnachi.ecommerce.dto.Purchase;
import com.martinnnachi.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
