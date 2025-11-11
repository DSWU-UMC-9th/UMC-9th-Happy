package com.example.umc9th2.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -145561848L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.example.umc9th2.global.entity.QBaseEntity _super = new com.example.umc9th2.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOwnerReply ownerReply;

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final StringPath reviewImage = createString("reviewImage");

    public final StringPath reviewText = createString("reviewText");

    public final com.example.umc9th2.domain.store.entity.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.umc9th2.domain.member.entity.QUser user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ownerReply = inits.isInitialized("ownerReply") ? new QOwnerReply(forProperty("ownerReply"), inits.get("ownerReply")) : null;
        this.store = inits.isInitialized("store") ? new com.example.umc9th2.domain.store.entity.QStore(forProperty("store"), inits.get("store")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc9th2.domain.member.entity.QUser(forProperty("user")) : null;
    }

}

