package com.example.springstudyprojects.order.controller;

import com.example.springstudyprojects.order.model.dto.NewOrderRequest;
import com.example.springstudyprojects.order.model.entity.Order;
import com.example.springstudyprojects.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public void newOrder(@RequestBody NewOrderRequest newOrderRequest){
        Order orders = orderService.newOrder(newOrderRequest);
    }

    @GetMapping
    public List<Long> getOrders(){
        List<Order> orders = orderService.getOrders();
        return orders.stream().map(order -> order.getTotalPrice()).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable(name = "id") Long id){
        orderService.deleteOrder(id);
    }

    @PatchMapping("/totalprice/{id}")
    public void updateTotalPrice(@PathVariable(name = "id") Long id){
        orderService.updateTotalPrice(id);
    }

    @PatchMapping("/orderstatus/{id}")
    public void updateOrderStatus(@PathVariable(name = "id") Long id){
        orderService.updateOrderStatus(id);
    }
}
