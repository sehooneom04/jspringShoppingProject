package com.example.springstudyprojects.item.repository;

import com.example.springstudyprojects.item.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
