package com.example.springstudyprojects.order.repository;

import com.example.springstudyprojects.order.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
