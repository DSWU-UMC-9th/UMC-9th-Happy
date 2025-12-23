package com.example.umc9th2.domain.member.service;

import com.example.umc9th2.domain.member.dto.UserReqDto;
import com.example.umc9th2.domain.member.dto.UserResDto;

public interface UserQueryService {

    // 로그인
    UserResDto.LoginDTO login(UserReqDto.LoginDTO dto);
}