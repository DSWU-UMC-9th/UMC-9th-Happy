package com.example.umc9th2.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDto {

    private String nickname;
    private Integer rating;
    private String reviewText;
    private String reviewImage;
    private String replyText;
}