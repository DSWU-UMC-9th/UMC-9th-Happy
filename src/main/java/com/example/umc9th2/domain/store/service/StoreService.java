package com.example.umc9th2.domain.store.service;

import com.example.umc9th2.domain.store.dto.StoreResponse;
import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Page<StoreResponse> searchStores(String region, String name, String sort, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Store> stores = storeRepository.searchStores(region, name, sort, pageable);
        return stores.map(StoreResponse::fromEntity);
    }
}
