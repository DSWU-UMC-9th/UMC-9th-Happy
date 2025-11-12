package com.example.umc9th2.domain.review.dto;

import lombok.AllArgsConstructor;
//import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponseDto {

    private String nickname;
    private Integer rating;
    private String reviewText;
    private String reviewImage;
    private String replyText;

//    @QueryProjection
//    public ReviewResponseDto(String nickname, Integer rating, String reviewText, String reviewImage, String replyText) {
//        this.nickname = nickname;
//        this.rating = rating;
//        this.reviewText = reviewText;
//        this.reviewImage = reviewImage;
//        this.replyText = replyText;
//    }
}