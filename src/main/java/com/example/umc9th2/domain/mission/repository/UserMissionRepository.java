package com.example.umc9th2.domain.mission.repository;

import com.example.umc9th2.domain.mission.entity.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}