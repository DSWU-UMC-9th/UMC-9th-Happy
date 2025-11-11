package com.example.umc9th2.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserFoodPreference is a Querydsl query type for UserFoodPreference
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserFoodPreference extends EntityPathBase<UserFoodPreference> {

    private static final long serialVersionUID = 46075126L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFoodPreference userFoodPreference = new QUserFoodPreference("userFoodPreference");

    public final QFoodType foodType;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QUserFoodPreference(String variable) {
        this(UserFoodPreference.class, forVariable(variable), INITS);
    }

    public QUserFoodPreference(Path<? extends UserFoodPreference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserFoodPreference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserFoodPreference(PathMetadata metadata, PathInits inits) {
        this(UserFoodPreference.class, metadata, inits);
    }

    public QUserFoodPreference(Class<? extends UserFoodPreference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodType = inits.isInitialized("foodType") ? new QFoodType(forProperty("foodType")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

