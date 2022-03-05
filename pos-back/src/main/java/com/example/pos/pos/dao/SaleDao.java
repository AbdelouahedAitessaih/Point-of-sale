package com.example.pos.pos.dao;

import com.example.pos.pos.dto.OrderDto;
import com.example.pos.pos.entity.Order;
import com.example.pos.pos.entity.Sale;
import com.example.pos.pos.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDao {

    @Autowired
    private SaleRepo saleRepo;

    private OrderDao orderDao;

    public SaleDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public List<Sale> getAllSales() {
        return this.saleRepo.findAll();
    }

    public List<Sale> getSalesByOrderId(Long orderId) {
        return this.saleRepo.findAllByOrderId(orderId);
    }

    public Order saveSale (List<OrderDto> order) {
        if(order.size() == 0){
            return null;
        }
        Order order1 = this.orderDao.saveOrder(order);
        order.forEach(o -> {
            Sale sale = new Sale();
            sale.setOrderId(order1.getOrderId());
            sale.setProductId(o.getProductId());
            this.saleRepo.save(sale);
        });
        return order1;
    }
}
