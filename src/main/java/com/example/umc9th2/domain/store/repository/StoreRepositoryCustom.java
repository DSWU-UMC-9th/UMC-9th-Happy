package com.example.umc9th2.domain.store.repository;

import com.example.umc9th2.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreRepositoryCustom {
    Page<Store> searchStores(String region, String name, String sort, Pageable pageable);
}