package com.example.boardmakers.domain.member.controller;

import com.example.boardmakers.domain.member.dto.MemberCreateRequest;
import com.example.boardmakers.domain.member.dto.MemberGetResponse;
import com.example.boardmakers.domain.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<Long> createMember(
        @RequestBody MemberCreateRequest request
    ) {
        Long memberId = memberService.createMember(request);
        return ResponseEntity.ok(memberId);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberGetResponse> getMember(
        @PathVariable("id") Long id
    ){
        MemberGetResponse mebmer =  memberService.getMember(id);
        return ResponseEntity.ok(mebmer);
    }

}
