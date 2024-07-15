package com.example.springstudyprojects.member.controller;

import com.example.springstudyprojects.member.model.dto.SignUpRequest;
import com.example.springstudyprojects.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/v2")
public class MemberControllerV2 {
    private final MemberService memberService;

    public MemberControllerV2(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping //데이터를 데이터 베이스에 추가하는 역할의 메소드
    public Long signUp(@Valid @RequestBody SignUpRequest request){
        return memberService.signUp(request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        memberService.deleteMember(id);
    }
}
