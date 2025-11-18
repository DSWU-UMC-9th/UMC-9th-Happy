package com.example.umc9th2.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

public class MissionResDTO {

    @Getter
    @Builder
    public static class UpdateMissionStatusResult {
        private Long userMissionId;
        private String missionName;
        private String status;
        private Integer pointEarned;
    }
}