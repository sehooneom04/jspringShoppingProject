package com.example.springstudyprojects.member.controller;

import com.example.springstudyprojects.member.model.dto.SaveMemberRequest;
import com.example.springstudyprojects.member.model.entity.Member;
import com.example.springstudyprojects.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

//실제로 요청을 보내는 유저와 가장 가까운 것 = controller
//restful API 찾아보기
@RestController
@RequestMapping("/member") //URL의 공통 부분  == postmapping("/member)을 한 번에
public class MemberControllerV1 {

    private final MemberService memberService;

    public MemberControllerV1(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping //API 문서 작성
    public String saveMember(@RequestBody SaveMemberRequest request) {
        Member member = Member.builder()
                        .name("엄세훈")
                        .build();
        memberService.saveMember(member);
        return "Success";
    }
    @GetMapping("/{id}") //{} pass bariable
    public String findMember(@PathVariable Long id){
        Member member = memberService.findMember(id);
        return member.getName();
    }
}