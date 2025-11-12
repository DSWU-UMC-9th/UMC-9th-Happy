package com.example.umc9th2.domain.store.repository;

import com.example.umc9th2.domain.store.entity.QRegion;
import com.example.umc9th2.domain.store.entity.QStore;
import com.example.umc9th2.domain.store.entity.Store;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryCustomImpl implements StoreRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Store> searchStores(String region, String name, String sort, Pageable pageable) {
        QStore store = QStore.store;
        QRegion qRegion = QRegion.region;
        BooleanBuilder builder = new BooleanBuilder();

        // 1️⃣ 지역 필터 (Region 이름 기준)
        if (region != null && !region.isBlank()) {
            builder.and(store.region.regionName.eq(region));
        }

        // 2️⃣ 이름 검색
        if (name != null && !name.isBlank()) {
            if (name.contains(" ")) { // 공백 포함 → 합집합
                String[] keywords = name.split("\\s+");
                BooleanBuilder nameBuilder = new BooleanBuilder();
                for (String keyword : keywords) {
                    nameBuilder.or(store.storeName.containsIgnoreCase(keyword));
                }
                builder.and(nameBuilder);
            } else { // 공백 없음
                builder.and(store.storeName.containsIgnoreCase(name));
            }
        }

        // 3️⃣ 정렬 조건
        OrderSpecifier<?> orderSpecifier = "name".equals(sort)
                ? store.storeName.asc().nullsLast()
                : store.id.desc(); // 최신순 (id 기준)

        // 4️⃣ 결과 조회
        List<Store> results = queryFactory
                .selectFrom(store)
                .join(store.region, qRegion).fetchJoin()
                .where(builder)
                .orderBy(orderSpecifier)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(store.count())
                .from(store)
                .join(store.region, qRegion)
                .where(builder)
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }
}