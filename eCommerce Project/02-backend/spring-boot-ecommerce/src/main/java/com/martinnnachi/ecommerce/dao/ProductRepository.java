package com.martinnnachi.ecommerce.dao;

import com.martinnnachi.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
