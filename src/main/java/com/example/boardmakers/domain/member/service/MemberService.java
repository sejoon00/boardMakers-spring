package com.example.boardmakers.domain.member.service;

import com.example.boardmakers.domain.member.dto.MemberCreateRequest;
import com.example.boardmakers.domain.member.dto.MemberGetResponse;

public interface MemberService {

    Long createMember(MemberCreateRequest request);

    MemberGetResponse getMember(Long id);

}
