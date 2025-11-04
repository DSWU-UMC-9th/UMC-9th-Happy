package com.example.umc9th2.domain.mission.dto;

import com.example.umc9th2.domain.mission.entity.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserMissionDto {
    private String storeName;
    private Integer rewardPoint;
    private MissionStatus status;
    private String missionDescription;
}