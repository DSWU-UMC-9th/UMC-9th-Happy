package com.example.umc9th2.domain.member.code;

import com.example.umc9th2.global.apiPayload.code.BaseErrorCode;
import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "US001", "사용자를 찾을 수 없습니다."),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "US002", "이미 존재하는 사용자입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
