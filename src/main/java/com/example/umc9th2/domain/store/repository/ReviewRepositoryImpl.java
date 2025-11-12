//package com.example.umc9th2.domain.store.repository;
//
//import com.example.umc9th2.domain.review.dto.ReviewResponseDto;
//import com.example.umc9th2.domain.review.entity.QOwnerReply;
//import com.example.umc9th2.domain.review.entity.QReview;
//import com.querydsl.core.types.Projections;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import jakarta.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
//
//    private final JPAQueryFactory queryFactory;
//
//    public ReviewRepositoryImpl(EntityManager em) {
//        this.queryFactory = new JPAQueryFactory(em);
//    }
//
//    @Override
//    public List<ReviewResponseDto> findReviews(Long storeId, Integer rating) {
//        QReview r = QReview.review;
//        QOwnerReply ory = QOwnerReply.ownerReply;
//
//        return queryFactory
//                .select(Projections.constructor(ReviewResponseDto.class,
//                        r.user.nickname,
//                        r.rating,
//                        r.reviewText,
//                        r.reviewImage,
//                        ory.replyText))
//                .from(r)
//                .leftJoin(r.ownerReply, ory)
//                .where(storeIdEq(storeId), ratingEq(rating))
//                .fetch();
//    }
//
//    // 동적 필터링
//    private BooleanExpression storeIdEq(Long storeId) {
//        return storeId != null ? QReview.review.store.id.eq(storeId) : null;
//    }
//
//    private BooleanExpression ratingEq(Integer rating) {
//        return rating != null ? QReview.review.rating.eq(rating) : null;
//    }
//}
