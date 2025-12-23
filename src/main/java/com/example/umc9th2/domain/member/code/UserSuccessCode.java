package com.example.umc9th2.domain.member.code;

import com.example.umc9th2.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserSuccessCode implements BaseSuccessCode {

    SIGN_UP_SUCCESS("USER200", "회원가입 성공"),
    LOGIN_SUCCESS("USER201", "로그인 성공");

    private final String code;
    private final String message;

    @Override
    public HttpStatus getStatus() {
        return null;
    }
}
