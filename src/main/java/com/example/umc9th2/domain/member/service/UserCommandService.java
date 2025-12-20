package com.example.umc9th2.domain.member.service;


import com.example.umc9th2.domain.member.dto.UserReqDto;
import com.example.umc9th2.domain.member.dto.UserResDto;

public interface UserCommandService {

    // 회원가입
    UserResDto.JoinDTO signup(UserReqDto.JoinDTO dto);
}