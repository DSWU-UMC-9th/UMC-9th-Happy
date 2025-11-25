package com.example.umc9th2.domain.mission.entity;

import com.example.umc9th2.domain.member.entity.User;
import com.example.umc9th2.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_mission")
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
    @Column(columnDefinition = "ENUM('inProgress','progressCompleted') DEFAULT 'inProgress'")
    private MissionStatus status;

    private LocalDateTime completedAt;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer pointEarned;

    @Builder
    public UserMission(User user, Mission mission, MissionStatus missionStatus) {
        this.user = user;
        this.mission = mission;
        this.status = missionStatus;
    }

    public void setStatus(MissionStatus status) {
        this.status = status;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public void setPointEarned(Integer pointEarned) {
        this.pointEarned = pointEarned;
    }

}
