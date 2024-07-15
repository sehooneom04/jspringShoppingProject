package com.example.springstudyprojects.order.model.dto;

import com.example.springstudyprojects.order.model.entity.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class NewOrderRequest {
    private Long totalPrice;
    private OrderStatus orderStatus;
    private Date date;
}
