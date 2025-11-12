package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.code.MissionSuccessCode;
import com.example.umc9th2.domain.mission.converter.MissionConverter;
import com.example.umc9th2.domain.mission.dto.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.UserMission;
import com.example.umc9th2.domain.mission.service.MissionService;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PatchMapping("/{userMissionId}/complete")
    public ApiResponse<MissionResDTO.UpdateMissionStatusResult> completeMission(
            @PathVariable Long userMissionId
    ) {
        UserMission userMission = missionService.completeMission(userMissionId);

        return ApiResponse.onSuccess(
                MissionSuccessCode.MISSION_UPDATE_SUCCESS,
                MissionConverter.toUpdateMissionStatusResult(userMission)
        );
    }
}