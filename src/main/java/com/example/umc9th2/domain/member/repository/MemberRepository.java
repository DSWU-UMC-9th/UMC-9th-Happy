package com.example.umc9th2.domain.member.repository;

import com.example.umc9th2.domain.member.dto.MyPageDto;
import com.example.umc9th2.domain.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<User, Long> {

    @Query("""
    SELECT new com.example.umc9th2.domain.member.dto.MyPageDto(
        u.nickname,
        u.email,
        u.phone,
        COALESCE(SUM(um.pointEarned), 0)
    )
    FROM User u
    LEFT JOIN u.missions um
    WHERE u.id = :userId
    GROUP BY u.id, u.nickname, u.email, u.phone
""")
    MyPageDto findMyPageInfo(@Param("userId") Long userId);
}