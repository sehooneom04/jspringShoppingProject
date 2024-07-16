package com.example.springstudyprojects.order.service;

import com.example.springstudyprojects.order.model.dto.NewOrderRequest;
import com.example.springstudyprojects.order.model.entity.OrderStatus;
import com.example.springstudyprojects.order.model.entity.Order;
import com.example.springstudyprojects.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order newOrder(NewOrderRequest newOrderRequest){
        Order orders = Order.builder().totalPrice(newOrderRequest.getTotalPrice())
                                        .orderStatus(newOrderRequest.getOrderStatus())
                                        .date(newOrderRequest.getDate()).build();
        orderRepository.save(orders);
        return orders;
    }
    public void deleteOrder(Long id){
        orderRepository.delete(orderRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("존재하지 않는 주문입니다.")));
    }

    public List<Order> getOrders(){ return orderRepository.findAll();}

    public void updateTotalPrice(Long id){
        orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다.")).setTotalPrice();
    }
    public void updateOrderStatus(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));
        if(order.getOrderStatus().equals(OrderStatus.FINISHED)) order.setOrderStatus(OrderStatus.NOTFINISHED);
        else order.setOrderStatus(OrderStatus.FINISHED);
    }
}
