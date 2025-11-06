package com.example.umc9th2.domain.review.service;

import com.example.umc9th2.domain.member.entity.User;
import com.example.umc9th2.domain.member.repository.UserRepository;
import com.example.umc9th2.domain.review.dto.ReviewResDTO;
import com.example.umc9th2.domain.review.dto.ReviewResponseDto;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.repository.StoreRepository;
import com.example.umc9th2.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    /**
     * 리뷰 생성
     */
    public Review createReview(Long storeId, Integer rating, String reviewText, String reviewImage) {
        // 🔹 실제로는 로그인 유저의 ID를 SecurityContext 등에서 가져와야 함 (예시로 ID=1L)
        Long userId = 1L;

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("가게를 찾을 수 없습니다."));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Review review = Review.builder()
                .store(store)
                .user(user)
                .rating(rating)
                .reviewText(reviewText)
                .reviewImage(reviewImage)
                .build();

        return reviewRepository.save(review);

    }

    /**
     * 리뷰 조회
     */
    public ReviewResDTO.ReviewListResult getReviews(Long storeId, Integer rating) {
        List<ReviewResponseDto> reviewList = reviewRepository.findReviews(storeId, rating);
        return ReviewResDTO.fromEntities(reviewList);
    }
}