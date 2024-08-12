package com.example.boardmakers.domain.member.service;

import com.example.boardmakers.domain.member.dto.MemberCreateRequest;
import com.example.boardmakers.domain.member.dto.MemberGetResponse;
import com.example.boardmakers.domain.member.entity.Member;
import com.example.boardmakers.domain.member.repository.MemberRepository;
import com.example.boardmakers.global.error.exception.BusinessException;
import com.example.boardmakers.global.error.exception.ErrorCode;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long createMember(MemberCreateRequest request) {

        // 멤버 객체 생성
        Member member = new Member(request.username(), request.age());

        // 멤버 DB에 저장
        Member save = memberRepository.save(member);

        return save.getId();
    }

    @Override
    public MemberGetResponse getMember(Long id) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        return new MemberGetResponse(member.getName(), member.getAge());
    }

    public List<MemberGetResponse> getMemberList() {
         return memberRepository.findAll().stream()
            .map(member -> new MemberGetResponse(member.getName(), member.getAge()))
            .toList();
    }
}























