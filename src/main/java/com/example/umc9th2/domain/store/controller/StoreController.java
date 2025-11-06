package com.example.umc9th2.domain.store.controller;

import com.example.umc9th2.domain.store.code.StoreSuccessCode;
import com.example.umc9th2.domain.store.dto.StoreResponse;
import com.example.umc9th2.domain.store.service.StoreService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<StoreResponse>>> searchStores(
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "latest") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<StoreResponse> result = storeService.searchStores(region, name, sort, page, size);
        return ResponseEntity
                .status(StoreSuccessCode.STORE_SEARCH_SUCCESS.getStatus())
                .body(ApiResponse.onSuccess(
                        StoreSuccessCode.STORE_SEARCH_SUCCESS,
                        result
                ));
    }
}