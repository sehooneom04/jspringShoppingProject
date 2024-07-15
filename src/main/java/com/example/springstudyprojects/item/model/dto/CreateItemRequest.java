package com.example.springstudyprojects.item.model.dto;

import com.example.springstudyprojects.item.model.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateItemRequest {
    private String name;
    private Long price;
    private Category category;
}
