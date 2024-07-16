package com.example.springstudyprojects.member.model.entity;


import com.example.springstudyprojects.order.model.entity.Order;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String phoneNumber;
    private String city;
    private String street;
    private String zipcode;
    @OneToMany(mappedBy = "member")
    private List<Order> orders;


    @Builder
    public Member(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}




