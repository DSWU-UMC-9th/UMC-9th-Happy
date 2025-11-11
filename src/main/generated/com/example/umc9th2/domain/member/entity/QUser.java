package com.example.umc9th2.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1128908733L;

    public static final QUser user = new QUser("user");

    public final com.example.umc9th2.global.entity.QBaseEntity _super = new com.example.umc9th2.global.entity.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ListPath<UserFoodPreference, QUserFoodPreference> foodPreferences = this.<UserFoodPreference, QUserFoodPreference>createList("foodPreferences", UserFoodPreference.class, QUserFoodPreference.class, PathInits.DIRECT2);

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.example.umc9th2.domain.mission.entity.UserMission, com.example.umc9th2.domain.mission.entity.QUserMission> missions = this.<com.example.umc9th2.domain.mission.entity.UserMission, com.example.umc9th2.domain.mission.entity.QUserMission>createList("missions", com.example.umc9th2.domain.mission.entity.UserMission.class, com.example.umc9th2.domain.mission.entity.QUserMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<com.example.umc9th2.domain.review.entity.Review, com.example.umc9th2.domain.review.entity.QReview> reviews = this.<com.example.umc9th2.domain.review.entity.Review, com.example.umc9th2.domain.review.entity.QReview>createList("reviews", com.example.umc9th2.domain.review.entity.Review.class, com.example.umc9th2.domain.review.entity.QReview.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

