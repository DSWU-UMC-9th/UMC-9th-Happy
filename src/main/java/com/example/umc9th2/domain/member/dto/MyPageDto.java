package com.example.umc9th2.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageDto {
    private String nickname;
    private String email;
    private String phone;
    private Long totalPoint;
}