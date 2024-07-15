package com.example.springstudyprojects.member.repository;

import com.example.springstudyprojects.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
