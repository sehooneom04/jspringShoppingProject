package com.example.springstudyprojects.item.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "items")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Items {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long price;
    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private Category category;

    public Items(String name) {
        this.name = name;
    }
}
