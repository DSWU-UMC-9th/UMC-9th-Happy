package com.example.umc9th2.domain.review.dto;

//import com.querydsl.core.annotations.QueryProjection;
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

//    @QueryProjection
//    public ReviewResponseDto(String nickname, Integer rating, String reviewText, String reviewImage, String replyText) {
//        this.nickname = nickname;
//        this.rating = rating;
//        this.reviewText = reviewText;
//        this.reviewImage = reviewImage;
//        this.replyText = replyText;
//    }
}