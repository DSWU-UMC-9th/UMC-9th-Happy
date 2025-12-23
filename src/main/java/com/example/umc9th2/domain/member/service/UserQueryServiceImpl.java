package com.example.umc9th2.domain.member.service;

import com.example.umc9th2.domain.member.converter.UserConverter;
import com.example.umc9th2.domain.member.dto.UserReqDto;
import com.example.umc9th2.domain.member.dto.UserResDto;
import com.example.umc9th2.domain.member.entity.User;
import com.example.umc9th2.domain.member.repository.UserRepository;
import com.example.umc9th2.global.auth.details.CustomUserDetails;
import com.example.umc9th2.global.auth.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public UserResDto.LoginDTO login(UserReqDto.LoginDTO dto) {

        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        if(!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

        CustomUserDetails userDetails = new CustomUserDetails(user);
        String accessToken = jwtUtil.createAccessToken(userDetails);

        return UserConverter.toLoginDTO(user, accessToken);
    }
}