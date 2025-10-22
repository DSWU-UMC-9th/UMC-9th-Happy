package com.example.umc9th2.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponseDto {
    private String nickname;
    private Integer rating;
    private String reviewText;
    private String reviewImage;
    private String replyText;
}