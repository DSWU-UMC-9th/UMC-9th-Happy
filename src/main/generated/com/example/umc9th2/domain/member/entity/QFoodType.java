package com.example.umc9th2.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodType is a Querydsl query type for FoodType
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodType extends EntityPathBase<FoodType> {

    private static final long serialVersionUID = -1675738198L;

    public static final QFoodType foodType = new QFoodType("foodType");

    public final StringPath foodName = createString("foodName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<UserFoodPreference, QUserFoodPreference> userPreferences = this.<UserFoodPreference, QUserFoodPreference>createList("userPreferences", UserFoodPreference.class, QUserFoodPreference.class, PathInits.DIRECT2);

    public QFoodType(String variable) {
        super(FoodType.class, forVariable(variable));
    }

    public QFoodType(Path<? extends FoodType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodType(PathMetadata metadata) {
        super(FoodType.class, metadata);
    }

}

