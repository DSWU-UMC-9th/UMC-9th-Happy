package com.example.umc9th2.domain.member.repository;

import com.example.umc9th2.domain.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    // 이메일로 조회
    Optional<User> findByEmail(String email);

}