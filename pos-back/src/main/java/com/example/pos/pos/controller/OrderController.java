package com.example.pos.pos.controller;

import com.example.pos.pos.dao.OrderDao;
import com.example.pos.pos.dao.SaleDao;
import com.example.pos.pos.dto.OrderDto;
import com.example.pos.pos.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SaleDao saleDao;

    @GetMapping()
    public List<Order> getAllOrders() {
      return this.orderDao.getAllOrders();
    }

    @PostMapping()
    public Order saveOrder(@RequestBody List<OrderDto> orderDto) {
        return this.saleDao.saveSale(orderDto);
    }

}
