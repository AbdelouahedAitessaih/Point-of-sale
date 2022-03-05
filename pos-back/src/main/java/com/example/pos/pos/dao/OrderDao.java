package com.example.pos.pos.dao;

import com.example.pos.pos.dto.OrderDto;
import com.example.pos.pos.entity.Order;
import com.example.pos.pos.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDao {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders(){
        return this.orderRepo.findAll();
    }

    public Order saveOrder(List<OrderDto> orderDto){
        Double total = 0.0;

        for (OrderDto order:orderDto) {
            total += order.getProductPrice();
        }

        Order order = new Order();
        order.setTotal(total);

        return this.orderRepo.save(order);
    }
}
