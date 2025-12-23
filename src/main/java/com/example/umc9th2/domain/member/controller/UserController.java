package com.example.umc9th2.domain.member.controller;

import com.example.umc9th2.domain.member.code.UserSuccessCode;
import com.example.umc9th2.domain.member.dto.UserReqDto;
import com.example.umc9th2.domain.member.dto.UserResDto;
import com.example.umc9th2.domain.member.service.UserCommandService;
import com.example.umc9th2.domain.member.service.UserQueryService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/sign-up")
    public ApiResponse<UserResDto.JoinDTO> signUp(
            @RequestBody @Valid UserReqDto.JoinDTO dto
    ) {
        return ApiResponse.onSuccess(
                UserSuccessCode.SIGN_UP_SUCCESS,
                userCommandService.signup(dto)
        );
    }

    @PostMapping("/login")
    public ApiResponse<UserResDto.LoginDTO> login(
            @RequestBody @Valid UserReqDto.LoginDTO dto
    ) {
        return ApiResponse.onSuccess(
                UserSuccessCode.LOGIN_SUCCESS,
                userQueryService.login(dto)
        );
    }
}