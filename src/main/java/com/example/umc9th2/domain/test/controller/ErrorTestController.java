package com.example.umc9th2.domain.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorTestController {

    @GetMapping("/test/error")
    public String triggerError() {
        throw new RuntimeException("테스트용 500 에러입니다!");
    }
}
