package com.example.umc9th2.domain.review.repository;

import com.example.umc9th2.domain.review.dto.ReviewResponseDto;
import com.example.umc9th2.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
//public interface ReviewRepository extends JpaRepository<Review, Long> {
//
//    @Query("""
//        SELECT new com.example.umc9th2.domain.review.dto.ReviewResponseDto(
//            r.user.nickname,
//            r.rating,
//            r.reviewText,
//            r.reviewImage,
//            ory.replyText
//        )
//        FROM Review r
//        LEFT JOIN r.ownerReply ory
//        WHERE r.store.id = :storeId
//    """)
//    List<ReviewResponseDto> findReviewsByStoreId(@Param("storeId") Long storeId);
}