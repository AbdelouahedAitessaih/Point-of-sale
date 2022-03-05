package com.example.pos.pos.repository;


import com.example.pos.pos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    public Product findProductByBarCode(String barCode);
}
