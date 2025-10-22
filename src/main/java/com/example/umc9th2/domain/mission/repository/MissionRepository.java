package com.example.umc9th2.domain.mission.repository;

import com.example.umc9th2.domain.mission.dto.HomeMissionDto;
import com.example.umc9th2.domain.mission.entity.Mission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query("""
    SELECT new com.example.umc9th2.domain.mission.dto.HomeMissionDto(
        r.regionName,
        COUNT(um.id),
        s.storeName,
        s.foodType.foodName,
        m.missionName,
        m.rewardPoint,
        CAST(FUNCTION('DATEDIFF', m.createdAt, CURRENT_DATE) AS long)
    )
    FROM Mission m
    JOIN m.store s
    JOIN s.region r
    LEFT JOIN m.userMissions um
    WHERE r.regionName = :regionName
      AND m.createdAt > :lastCreatedAt
    GROUP BY m.id, r.regionName, s.storeName, s.foodType.foodName
    ORDER BY m.createdAt ASC
""")
    List<HomeMissionDto> findAvailableMissions(
            @Param("regionName") String regionName,
            @Param("lastCreatedAt") LocalDateTime lastCreatedAt,
            Pageable pageable
    );
}