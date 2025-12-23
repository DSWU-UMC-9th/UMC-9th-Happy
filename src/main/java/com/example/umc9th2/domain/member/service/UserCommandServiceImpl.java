package com.example.umc9th2.domain.member.service;

import com.example.umc9th2.domain.member.converter.UserConverter;
import com.example.umc9th2.global.auth.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.umc9th2.domain.member.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.umc9th2.domain.member.dto.UserResDto;
import com.example.umc9th2.domain.member.dto.UserReqDto;
import com.example.umc9th2.domain.member.entity.User;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResDto.JoinDTO signup(UserReqDto.JoinDTO dto) {

        if (userRepository.findByEmail(dto.email()).isPresent()) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(dto.password());
        User user = UserConverter.toUser(dto, encodedPassword, Role.ROLE_USER);

        userRepository.save(user);
        return UserConverter.toJoinDTO(user);
    }
}
