package com.example.umc9th2.domain.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = -570786594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final StringPath address = createString("address");

    public final com.example.umc9th2.domain.member.entity.QFoodType foodType;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.example.umc9th2.domain.mission.entity.Mission, com.example.umc9th2.domain.mission.entity.QMission> missions = this.<com.example.umc9th2.domain.mission.entity.Mission, com.example.umc9th2.domain.mission.entity.QMission>createList("missions", com.example.umc9th2.domain.mission.entity.Mission.class, com.example.umc9th2.domain.mission.entity.QMission.class, PathInits.DIRECT2);

    public final StringPath ownerCode = createString("ownerCode");

    public final QRegion region;

    public final ListPath<com.example.umc9th2.domain.review.entity.Review, com.example.umc9th2.domain.review.entity.QReview> reviews = this.<com.example.umc9th2.domain.review.entity.Review, com.example.umc9th2.domain.review.entity.QReview>createList("reviews", com.example.umc9th2.domain.review.entity.Review.class, com.example.umc9th2.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final StringPath storeName = createString("storeName");

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodType = inits.isInitialized("foodType") ? new com.example.umc9th2.domain.member.entity.QFoodType(forProperty("foodType")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

