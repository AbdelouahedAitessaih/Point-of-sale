package com.example.pos.pos.controller;

import com.example.pos.pos.dao.SaleDao;
import com.example.pos.pos.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@CrossOrigin
public class SaleController {

    @Autowired
    private SaleDao saleDao;

    @GetMapping()
    public List<Sale> getAllSales() {
        return this.saleDao.getAllSales();
    }

    @GetMapping("/order")
    public List<Sale> getSalesByOrderId(@RequestParam Long orderId) {
        return this.saleDao.getSalesByOrderId(orderId);
    }
}
