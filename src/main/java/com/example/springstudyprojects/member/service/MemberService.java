package com.example.springstudyprojects.member.service;

import com.example.springstudyprojects.global.SecurtiryConfig;
import com.example.springstudyprojects.member.model.dto.SignUpRequest;
import com.example.springstudyprojects.member.model.entity.Member;
import com.example.springstudyprojects.member.repository.MemberRepository;
import com.example.springstudyprojects.order.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //final 붙은 필드만 생성자를 만든다는 뜻
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveMember(Member member) {
        memberRepository.save(member);
    }
    public Member findMember(Long id){
        Optional<Member> findMember = memberRepository.findById(id);
        if(findMember.isEmpty()){
            throw new RuntimeException();
        }
        return findMember.get();
    }
    public Long signUp(SignUpRequest signUpRequest){
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        Member member = Member.builder()
                .email(signUpRequest.getEmail())
                .name(signUpRequest.getName())
                .password(encodedPassword)
                .phoneNumber(signUpRequest.getPhoneNumber())
                .build();

        return memberRepository.save(member).getId();
    }

    public void deleteMember(Long id){
        memberRepository.delete(memberRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("존재하지 않는 회원입니다.")));
    }
    public List<Order> findEveryOrder(Long id){
        Member member = findMember(id);
        return member.getOrders();
    }
}
