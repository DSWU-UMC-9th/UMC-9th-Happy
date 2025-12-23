package com.example.umc9th2.domain.member.converter;
import com.example.umc9th2.domain.member.dto.UserReqDto;
import com.example.umc9th2.domain.member.dto.UserResDto;
import com.example.umc9th2.domain.member.entity.Gender;
import com.example.umc9th2.domain.member.entity.User;
import com.example.umc9th2.global.auth.enums.Role;

public class UserConverter {

    // 회원가입 DTO → User 엔티티
    public static User toUser(
            UserReqDto.JoinDTO dto,
            String encodedPassword,
            Role role
    ) {
        return User.builder()
                .email(dto.email())
                .name(dto.name())
                .password(encodedPassword)
                .role(role)
                .build();
    }

    // User → 회원가입 응답 DTO
    public static UserResDto.JoinDTO toJoinDTO(User user) {
        return UserResDto.JoinDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .build();
    }

    // User → 로그인 응답 DTO
    public static UserResDto.LoginDTO toLoginDTO(User user, String accessToken) {
        return UserResDto.LoginDTO.builder()
                .userId(user.getId())
                .accessToken(accessToken)
                .build();
    }
}