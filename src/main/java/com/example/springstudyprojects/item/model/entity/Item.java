package com.example.springstudyprojects.item.model.entity;


import com.example.springstudyprojects.orderitem.model.entity.OrderItem;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long price;
    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private Category category;
    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    public Item(String name) {
        this.name = name;
    }
}
