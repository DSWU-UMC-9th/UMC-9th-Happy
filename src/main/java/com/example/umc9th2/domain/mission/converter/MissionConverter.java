package com.example.umc9th2.domain.mission.converter;

import com.example.umc9th2.domain.mission.dto.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.UserMission;

public class MissionConverter {

    public static MissionResDTO.UpdateMissionStatusResult toUpdateMissionStatusResult(UserMission userMission) {
        return MissionResDTO.UpdateMissionStatusResult.builder()
                .userMissionId(userMission.getId())
                .missionName(userMission.getMission().getMissionName())
                .status(userMission.getStatus().name())
                .pointEarned(userMission.getPointEarned())
                .build();
    }
}