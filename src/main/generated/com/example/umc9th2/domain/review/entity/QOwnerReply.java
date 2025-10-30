package com.example.umc9th2.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOwnerReply is a Querydsl query type for OwnerReply
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOwnerReply extends EntityPathBase<OwnerReply> {

    private static final long serialVersionUID = 1201569703L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOwnerReply ownerReply = new QOwnerReply("ownerReply");

    public final com.example.umc9th2.global.entity.QBaseEntity _super = new com.example.umc9th2.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath replyText = createString("replyText");

    public final QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QOwnerReply(String variable) {
        this(OwnerReply.class, forVariable(variable), INITS);
    }

    public QOwnerReply(Path<? extends OwnerReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOwnerReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOwnerReply(PathMetadata metadata, PathInits inits) {
        this(OwnerReply.class, metadata, inits);
    }

    public QOwnerReply(Class<? extends OwnerReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

