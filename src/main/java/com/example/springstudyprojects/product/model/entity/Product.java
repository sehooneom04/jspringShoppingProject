package com.example.springstudyprojects.product.model.entity;

import com.example.springstudyprojects.order.model.entity.Orders;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;
    private String name;
    private int price;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Builder
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
