package com.example.umc9th2.domain.member.exception;

import com.example.umc9th2.domain.member.code.UserErrorCode;
import com.example.umc9th2.global.exception.BaseException;

public class UserException extends BaseException {

    public UserException(UserErrorCode errorCode) {
        super(errorCode);
    }
}
