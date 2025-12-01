package com.example.umc9th2.domain.mission.service;

import com.example.umc9th2.domain.member.code.UserErrorCode;
import com.example.umc9th2.domain.member.entity.User;
import com.example.umc9th2.domain.member.exception.UserException;
import com.example.umc9th2.domain.member.repository.UserRepository;
import com.example.umc9th2.domain.mission.code.MissionErrorCode;
import com.example.umc9th2.domain.mission.dto.MissionChallengeResponse;
import com.example.umc9th2.domain.mission.dto.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.Mission;
import com.example.umc9th2.domain.mission.entity.MissionStatus;
import com.example.umc9th2.domain.mission.entity.UserMission;
import com.example.umc9th2.domain.mission.exception.MissionException;
import com.example.umc9th2.domain.mission.repository.MissionRepository;
import com.example.umc9th2.domain.mission.repository.UserMissionRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

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
    public MissionChallengeResponse challengeMission(Long missionId, Long userId) {

        // 1. User 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        // 2. Mission 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        // 3. 이미 도전 중인지 체크
        boolean exists = userMissionRepository
                .findByUserIdAndMissionId(userId, missionId)
                .isPresent();

        if (exists) {
            throw new MissionException(MissionErrorCode.ALREADY_IN_PROGRESS);
        }

        // 4. UserMission 생성
        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .missionStatus(MissionStatus.inProgress) // ← 상태 변경
                .build();

        userMissionRepository.save(userMission);

        // 5. 응답 생성
        return new MissionChallengeResponse(
                userMission.getId(),
                userMission.getStatus().name()
        );
    }


    public MissionResDTO.MissionListResult getInProgressMissions(Long userId, int page) {
        PageRequest pageable = PageRequest.of(page - 1, 10);

        List<UserMission> userMissions = userMissionRepository
                .findByUser_IdAndStatus(userId, MissionStatus.inProgress, pageable)
                .getContent();

        List<MissionResDTO.MissionDetail> missionDetails = userMissions.stream()
                .map(um -> MissionResDTO.MissionDetail.builder()
                        .userMissionId(um.getId())
                        .missionName(um.getMission().getMissionName())
                        .storeName(um.getMission().getStore().getStoreName())
                        .status(um.getStatus().name())
                        .pointEarned(um.getPointEarned())
                        .build())
                .collect(Collectors.toList());

        return MissionResDTO.MissionListResult.builder()
                .missions(missionDetails)
                .build();
    }


    public List<Mission> getMissionsByStore(Long storeId) {
        return missionRepository.findByStore_Id(storeId);
    }


}