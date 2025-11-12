package com.example.umc9th2.domain.review.repository;

import com.example.umc9th2.domain.review.dto.ReviewResponseDto;
import com.example.umc9th2.domain.review.entity.QReview;
import com.example.umc9th2.domain.store.entity.QStore;
import com.example.umc9th2.domain.member.entity.QUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReviewResponseDto> findReviews(Long storeId, Integer rating) {
        QReview review = QReview.review;
        QStore store = QStore.store;
        QUser user = QUser.user;

        var query = queryFactory
                .select(Projections.constructor(
                        ReviewResponseDto.class,
                        user.nickname,
                        review.rating,
                        review.reviewText,
                        review.reviewImage,
                        review.ownerReply.replyText
                ))
                .from(review)
                .join(review.store, store)
                .join(review.user, user);

        if (storeId != null) {
            query.where(store.id.eq(storeId));
        }
        if (rating != null) {
            query.where(review.rating.eq(rating));
        }

        return query.fetch();
    }
}