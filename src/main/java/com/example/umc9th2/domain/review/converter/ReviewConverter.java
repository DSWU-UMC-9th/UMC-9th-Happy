package com.example.umc9th2.domain.review.converter;

import com.example.umc9th2.domain.review.dto.ReviewResDTO;
import com.example.umc9th2.domain.review.entity.Review;

public class ReviewConverter {

    public static ReviewResDTO.CreateReviewResult toCreateReviewResult(Review review) {
        return ReviewResDTO.CreateReviewResult.builder()
                .reviewId(review.getId())
                .storeName(review.getStore().getStoreName())
                .userName(review.getUser().getName())
                .rating(review.getRating())
                .reviewText(review.getReviewText())
                .reviewImage(review.getReviewImage())
                .build();
    }
}