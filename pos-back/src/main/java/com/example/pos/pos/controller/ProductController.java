package com.example.pos.pos.controller;

import com.example.pos.pos.dao.ProductDao;
import com.example.pos.pos.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping()
    public List<Product> getAllProducts() {
        return this.productDao.getAllProducts();
    }

    @GetMapping("/id")
    public Product getProductById(@RequestParam Long productId) {
        return this.productDao.getProductById(productId);
    }

    @GetMapping("/barCode")
    public Product getProductByBarcode(@RequestParam String barCode) {
        return this.productDao.getProductByBarCode(barCode);
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        return this.productDao.addProduct(product);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product) {
        return this.productDao.updateProduct(product);
    }

    @DeleteMapping()
    public String deleteProduct (@RequestParam Long productId) {
        this.productDao.deleteProduct(productId);
        return "Product Deleted";
    }
}
