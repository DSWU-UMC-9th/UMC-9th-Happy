package com.example.umc9th2.domain.mission.entity;

import com.example.umc9th2.domain.member.entity.User;
import com.example.umc9th2.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "User_Mission")
public class UserMission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('진행중','진행완료') DEFAULT '진행중'")
    private MissionStatus status;

    private LocalDateTime completedAt;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer pointEarned;
}
