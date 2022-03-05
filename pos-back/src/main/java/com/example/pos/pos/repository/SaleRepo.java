package com.example.pos.pos.repository;

import com.example.pos.pos.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {

    List<Sale> findAllByOrderId(Long orderId);
}
