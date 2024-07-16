package com.example.springstudyprojects.orderitem.model.entity;

import com.example.springstudyprojects.item.model.entity.Item;
import com.example.springstudyprojects.order.model.entity.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderItem { // 주문에 들어간 상품 (중간 매핑 다 대 다 )
    @Id
    @GeneratedValue
    @Column(name = "orderitem_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
