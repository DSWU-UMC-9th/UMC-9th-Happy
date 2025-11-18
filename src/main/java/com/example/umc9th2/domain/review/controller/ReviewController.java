package com.example.umc9th2.domain.review.controller;

import com.example.umc9th2.domain.review.code.ReviewSuccessCode;
import com.example.umc9th2.domain.review.converter.ReviewConverter;
import com.example.umc9th2.domain.review.dto.ReviewResDTO;
import com.example.umc9th2.domain.review.dto.ReviewResponseDto;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.review.service.ReviewService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResDTO.CreateReviewResult> createReview(
            @RequestParam Long storeId,
            @RequestParam Integer rating,
            @RequestParam String reviewText,
            @RequestParam(required = false) String reviewImage
    ) {
        Review review = reviewService.createReview(storeId, rating, reviewText, reviewImage);

        return ApiResponse.onSuccess(
                ReviewSuccessCode.REVIEW_CREATE_SUCCESS,
                ReviewConverter.toCreateReviewResult(review)
        );
    }


    @GetMapping
    public ApiResponse<ReviewResDTO.ReviewListResult> getReviews(
            @RequestParam Long storeId,
            @RequestParam(required = false) Integer rating
    ) {
        ReviewResDTO.ReviewListResult result = reviewService.getReviews(storeId, rating);
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_READ_SUCCESS, result);
    }
}