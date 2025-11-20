package com.example.umc9th2.global.exception;

import com.example.umc9th2.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final BaseErrorCode errorCode;

    public BaseException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
