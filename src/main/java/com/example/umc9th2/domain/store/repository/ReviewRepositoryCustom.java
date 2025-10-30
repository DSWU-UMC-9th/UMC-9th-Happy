package com.example.umc9th2.domain.store.repository;

import com.example.umc9th2.domain.review.dto.ReviewResponseDto;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewResponseDto> findReviews(Long storeId, Integer rating);
}
