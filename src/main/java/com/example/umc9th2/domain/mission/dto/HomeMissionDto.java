package com.example.umc9th2.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
public class HomeMissionDto {
    private String regionName;
    private Long userMissionCount;
    private String storeName;
    private String foodName;
    private String missionName;
    private int rewardPoint;
    private Long daysSinceCreated;

    public HomeMissionDto(String regionName, Long userMissionCount, String storeName,
                          String foodName, String missionName, int rewardPoint, Long daysSinceCreated) {
        this.regionName = regionName;
        this.userMissionCount = userMissionCount;
        this.storeName = storeName;
        this.foodName = foodName;
        this.missionName = missionName;
        this.rewardPoint = rewardPoint;
        this.daysSinceCreated = daysSinceCreated;
    }
}