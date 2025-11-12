package com.example.umc9th2.domain.store.code;

import com.example.umc9th2.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreSuccessCode implements BaseSuccessCode {
    STORE_SEARCH_SUCCESS(HttpStatus.OK, "STORE_SEARCH_200", "가게 검색이 성공적으로 조회되었습니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}