package com.example.springstudyprojects.order.controller;

import com.example.springstudyprojects.order.model.dto.NewOrderRequest;
import com.example.springstudyprojects.order.model.entity.Order;
import com.example.springstudyprojects.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void newOrder(@RequestBody NewOrderRequest newOrderRequest) {
        Order orders = orderService.newOrder(newOrderRequest);
    }

    @GetMapping("/find/{id}")
    public @ResponseBody ResponseEntity findOrder(@PathVariable(name = "id") Long id) {
        Order order = orderService.findOrder(id);
        return new ResponseEntity<Long>(order.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable(name = "id") Long id) {
        orderService.deleteOrder(id);
    }

    @PatchMapping("/totalprice/{id}")
    public void updateTotalPrice(@PathVariable(name = "id") Long id) {
        orderService.updateTotalPrice(id);
    }

    @PatchMapping("/orderstatus/{id}")
    public void updateOrderStatus(@PathVariable(name = "id") Long id) {
        orderService.updateOrderStatus(id);
    }
}
