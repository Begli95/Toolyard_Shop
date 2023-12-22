package com.toolyard.toolyard_shop.dao;

import com.toolyard.toolyard_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
