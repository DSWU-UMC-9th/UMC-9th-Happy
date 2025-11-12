package com.example.umc9th2.domain.review.dto;

import com.example.umc9th2.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewResDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReviewResult {
        private Long reviewId;
        private String storeName;
        private String userName;
        private Integer rating;
        private String reviewText;
        private String reviewImage;
    }
    @Getter
    @Builder
    public static class ReviewDetail {
        private String nickname;
        private Integer rating;
        private String reviewText;
        private String reviewImage;
        private String replyText;
    }

    @Getter
    @Builder
    public static class ReviewListResult {
        private List<ReviewDetail> reviews;
    }

    // 변환용 메서드
    public static ReviewResDTO.CreateReviewResult fromEntity(Review review) {
        return CreateReviewResult.builder()
                .reviewId(review.getId())
                .userName(review.getUser().getNickname())
                .rating(review.getRating())
                .reviewText(review.getReviewText())
                .reviewImage(review.getReviewImage())
                .build();
    }

    public static ReviewResDTO.ReviewListResult fromEntities(List<ReviewResponseDto> reviewList) {
        List<ReviewDetail> reviews = reviewList.stream()
                .map(r -> ReviewDetail.builder()
                        .nickname(r.getNickname())
                        .rating(r.getRating())
                        .reviewText(r.getReviewText())
                        .reviewImage(r.getReviewImage())
                        .replyText(r.getReplyText())
                        .build())
                .collect(Collectors.toList());

        return ReviewListResult.builder().reviews(reviews).build();
    }
}