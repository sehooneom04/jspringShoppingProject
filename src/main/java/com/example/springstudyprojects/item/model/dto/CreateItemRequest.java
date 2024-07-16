package com.example.springstudyprojects.item.model.dto;

import com.example.springstudyprojects.item.model.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
public class CreateItemRequest {
    private String name;
    private Long price;
    private Category category;

    @Builder
    public CreateItemRequest(String name, Long price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
