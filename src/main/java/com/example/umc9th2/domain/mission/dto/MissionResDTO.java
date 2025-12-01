package com.example.umc9th2.domain.mission.dto;

import com.example.umc9th2.domain.mission.entity.UserMission;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class MissionResDTO {

    @Getter
    @Builder
    public static class UpdateMissionStatusResult {
        private Long userMissionId;
        private String missionName;
        private String status;
        private Integer pointEarned;
    }

    @Getter
    @Builder
    public static class MissionDetail {
        private Long userMissionId;
        private String missionName;
        private String storeName;
        private String status;
        private Integer pointEarned;
    }

    @Getter
    @Builder
    public static class MissionListResult {
        private List<MissionDetail> missions;

        public static MissionListResult fromEntities(List<UserMission> userMissions) {
            List<MissionDetail> list = userMissions.stream()
                    .map(um -> MissionDetail.builder()
                            .userMissionId(um.getId())
                            .missionName(um.getMission().getMissionName())
                            .storeName(um.getMission().getStore().getStoreName())
                            .pointEarned(um.getMission().getRewardPoint())
                            .build())
                    .collect(Collectors.toList());
            return MissionListResult.builder().missions(list).build();
        }
    }
}