package com.example.boardmakers.domain.member.dto;

public record MemberCreateRequest(
    String username,
    int age
) {

}
