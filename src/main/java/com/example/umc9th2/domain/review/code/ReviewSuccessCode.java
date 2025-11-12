package com.example.umc9th2.domain.review.code;

import com.example.umc9th2.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    REVIEW_CREATE_SUCCESS(HttpStatus.CREATED, "REVIEW201", "리뷰가 성공적으로 등록되었습니다."),
    REVIEW_UPDATE_SUCCESS(HttpStatus.OK, "REVIEW200_1", "리뷰가 성공적으로 수정되었습니다."),
    REVIEW_DELETE_SUCCESS(HttpStatus.OK, "REVIEW200_2", "리뷰가 성공적으로 삭제되었습니다."),
    REVIEW_READ_SUCCESS(HttpStatus.OK, "REVIEW_200", "리뷰 목록이 성공적으로 조회되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}