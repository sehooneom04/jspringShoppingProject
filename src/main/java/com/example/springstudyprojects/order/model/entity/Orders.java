package com.example.springstudyprojects.order.model.entity;

import com.example.springstudyprojects.product.model.entity.Product;
import com.example.springstudyprojects.member.model.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Orders {
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
    private List<Product> products;

    public void setTotalPrice(){
        for(Product p:products){
            totalPrice += p.getPrice();
        }
    }
    public void setOrderStatus(OrderStatus os){
        this.orderStatus = os;
    }
}
