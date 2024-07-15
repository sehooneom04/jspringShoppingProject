package com.example.springstudyprojects.order.controller;

import com.example.springstudyprojects.order.model.dto.NewOrderRequest;
import com.example.springstudyprojects.order.model.entity.Orders;
import com.example.springstudyprojects.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Orders")
@RequiredArgsConstructor
public class OrderController {
    private OrderService orderService;
    @PostMapping
    public void newOrder(@RequestBody NewOrderRequest newOrderRequest){
        Orders orders = orderService.newOrder(newOrderRequest);
    }

    @GetMapping
    public List<Long> getOrders(){
        List<Orders> orders = orderService.getOrders();
        return orders.stream().map(order -> order.getTotalPrice()).collect(Collectors.toList());
    }

    @DeleteMapping
    public void deleteOrder(@RequestParam Long id){
        orderService.deleteOrder(id);
    }

    @PatchMapping("/Orders/updatetotalprice")
    public void updateTotalPrice(@RequestParam Long id){
        orderService.updateTotalPrice(id);
    }

    @PatchMapping("/Orders/updateorderstatus")
    public void updateOrderStatus(@RequestParam Long id){
        orderService.updateOrderStatus(id);
    }
}
