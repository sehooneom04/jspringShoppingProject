package com.example.springstudyprojects.order.model.entity;

import com.example.springstudyprojects.orderitem.model.entity.OrderItem;
import com.example.springstudyprojects.member.model.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name = "orders")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    private Long totalPrice;
    private OrderStatus orderStatus;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public void setTotalPrice(){
        totalPrice = Long.valueOf(0);
        for(OrderItem i:orderItems){
            totalPrice += i.getItem().getPrice();
        }
    }
    public void setOrderStatus(OrderStatus os){
        this.orderStatus = os;
    }
}
