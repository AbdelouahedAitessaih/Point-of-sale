package com.example.pos.pos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Table(name = "sale")
@Entity
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long saleId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
}
