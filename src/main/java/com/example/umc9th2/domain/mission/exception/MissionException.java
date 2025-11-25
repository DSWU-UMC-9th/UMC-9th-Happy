package com.example.umc9th2.domain.mission.exception;

import com.example.umc9th2.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th2.global.exception.BaseException;

public class MissionException extends BaseException {
    public MissionException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
