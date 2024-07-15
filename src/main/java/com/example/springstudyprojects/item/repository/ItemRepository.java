package com.example.springstudyprojects.item.repository;

import com.example.springstudyprojects.item.model.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Long> {
}
