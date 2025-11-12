package com.example.umc9th2.global.apiPayload.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    // 현재 활성화된 환경(local, dev, prod 등)
    @Value("${spring.profiles.active:local}")
    private String activeProfile;

    @Value("${discord.webhook.url}")
    private String discordWebhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        // favicon.ico 요청 무시
//        if (request.getDescription(false).contains("favicon.ico")) {
//            log.info("favicon.ico 요청 무시");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }

        log.error("❌ 서버 에러 발생: {}", ex.getMessage(), ex);

        sendDiscordErrorAlert(ex, request);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "서버 내부 오류가 발생했습니다."));
    }

    private void sendDiscordErrorAlert(Exception ex, WebRequest request) {
        // 로컬 환경일 경우 Discord 전송 X
        if ("local".equals(activeProfile) || discordWebhookUrl == null || discordWebhookUrl.isBlank()) {
            log.info("로컬 환경에서는 Discord 알림을 전송하지 않습니다.");
            return;
        }

        try {
            Map<String, Object> json = new HashMap<>();
            String message = """
                    🚨 **500 INTERNAL SERVER ERROR 발생!**
                    
                    🕒 발생 시각: %s
                    🌐 요청 URL: %s
                    💥 예외 메시지: %s
                    🧩 예외 클래스: %s
                    """.formatted(
                    LocalDateTime.now(),
                    request.getDescription(false),
                    ex.getMessage(),
                    ex.getClass().getName()
            );

            json.put("content", message);
            restTemplate.postForEntity(discordWebhookUrl, json, String.class);

        } catch (Exception e) {
            log.error("디스코드 알림 전송 실패: {}", e.getMessage());
        }
    }
}
