package com.example.umc9th2.domain.mission.repository;

import com.example.umc9th2.domain.mission.entity.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);
}
