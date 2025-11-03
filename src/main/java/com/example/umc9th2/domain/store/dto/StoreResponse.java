package com.example.umc9th2.domain.store.dto;

import com.example.umc9th2.domain.store.entity.Store;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreResponse {
    private Long id;
    private String storeName;
    private String regionName;
    private String address;

    public static StoreResponse fromEntity(Store store) {
        return StoreResponse.builder()
                .id(store.getId())
                .storeName(store.getStoreName())
                .regionName(store.getRegion().getRegionName()) // Region 엔티티의 이름 필드 사용
                .address(store.getAddress())
                .build();
    }
}
