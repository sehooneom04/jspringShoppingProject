package com.example.springstudyprojects.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 데이터 트랜스퍼 오브젝트 >> json으로 요청을 받아서 매핑하기 위해 사용되는 것
//스프링 프레임워크3 dto 검색해보기
@Getter
@NoArgsConstructor
@Setter
public class SaveMemberRequest {

    private String name;
    private String city;
    private String street;
    private String zipcode;
}

