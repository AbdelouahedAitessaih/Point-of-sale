package com.example.pos.pos.dao;

import com.example.pos.pos.entity.Product;
import com.example.pos.pos.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    public Product getProductById(Long productId) {
        Optional<Product> product = this.productRepo.findById(productId);
        return product.isPresent() ? product.get() : null;
    }

    public Product getProductByBarCode(String barCode) {
        Optional<Product> product = Optional.ofNullable(this.productRepo.findProductByBarCode(barCode));
        return product.isPresent() ? product.get() : null;
    }

    public Product addProduct(Product product) {
        return this.productRepo.save(product);
    }

    public Product updateProduct(Product product) {
        return this.productRepo.save(product);
    }

    public void deleteProduct(Long productId) {
        this.productRepo.deleteById(productId);
    }
}
