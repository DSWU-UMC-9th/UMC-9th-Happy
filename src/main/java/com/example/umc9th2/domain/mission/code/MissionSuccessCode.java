package com.example.umc9th2.domain.mission.code;

import com.example.umc9th2.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    MISSION_UPDATE_SUCCESS(HttpStatus.OK, "MISSION200_1", "미션 상태가 성공적으로 변경되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}