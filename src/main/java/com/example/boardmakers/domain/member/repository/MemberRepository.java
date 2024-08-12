package com.example.boardmakers.domain.member.repository;

import com.example.boardmakers.domain.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByAge(int age);
}
