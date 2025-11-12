package com.example.umc9th2.domain.mission.repository;

import com.example.umc9th2.domain.mission.dto.UserMissionDto;
import com.example.umc9th2.domain.mission.entity.UserMission;
import com.example.umc9th2.domain.mission.entity.MissionStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("""
        SELECT new com.example.umc9th2.domain.mission.dto.UserMissionDto(
            um.mission.store.storeName,
            um.mission.rewardPoint,
            um.status,
            um.mission.description
        )
        FROM UserMission um
        WHERE um.user.id = :userId
          AND um.status IN :statusList
        ORDER BY COALESCE(um.completedAt, um.createdAt) DESC
    """)
    List<UserMissionDto> findUserMissions(
            @Param("userId") Long userId,
            @Param("statusList") List<MissionStatus> statusList,
            Pageable pageable
    );
}