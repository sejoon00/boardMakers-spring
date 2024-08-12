package com.example.boardmakers.domain.post;

import com.example.boardmakers.domain.member.entity.Member;

public class Post {

    private Member member;

    public Post(Member member) {
        this.member = member;
    }
}
