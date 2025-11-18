package com.example.umc9th2.domain.mission.service;

import com.example.umc9th2.domain.mission.entity.MissionStatus;
import com.example.umc9th2.domain.mission.entity.UserMission;
import com.example.umc9th2.domain.mission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final UserMissionRepository userMissionRepository;

    @Transactional
    public UserMission completeMission(Long userMissionId) {
        UserMission userMission = userMissionRepository.findById(userMissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 미션을 찾을 수 없습니다."));

        if (userMission.getStatus() == MissionStatus.progressCompleted) {
            throw new IllegalStateException("이미 완료된 미션입니다.");
        }

        userMission.getClass(); // 더티체킹 감지를 위한 액세스
        userMission.setStatus(MissionStatus.progressCompleted);
        userMission.setCompletedAt(LocalDateTime.now());
        userMission.setPointEarned(userMission.getMission().getRewardPoint());

        return userMission;
    }
}