package com.example.umc9th2.domain.member.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserReqDto {

    // 회원가입
    public record JoinDTO(
            @NotBlank String name,
            @NotBlank String nickname,
            @NotNull String gender,
            LocalDate birthDate,
            String address,
            @NotBlank String email,
            @NotBlank String password,
            @NotBlank String phone
    ) {}

    // 로그인
    public record LoginDTO(
            @NotBlank String email,
            @NotBlank String password
    ) {}
}