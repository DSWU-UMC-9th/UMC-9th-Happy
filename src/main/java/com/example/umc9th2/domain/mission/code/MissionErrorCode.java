package com.example.umc9th2.domain.mission.code;

import com.example.umc9th2.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum MissionErrorCode implements BaseErrorCode {
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MS001", "해당 미션을 찾을 수 없습니다."),
    ALREADY_IN_PROGRESS(HttpStatus.BAD_REQUEST, "MS002", "이미 도전 중인 미션입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
