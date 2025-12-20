package com.example.umc9th2.domain.member.dto;

import lombok.Builder;

public class UserResDto {

    // 회원가입
    @Builder
    public record JoinDTO(
            Long userId,
            String name,
            String nickname,
            String email
    ) {}

    // 로그인
    @Builder
    public record LoginDTO(
            Long userId,
            String accessToken
    ) {}
}