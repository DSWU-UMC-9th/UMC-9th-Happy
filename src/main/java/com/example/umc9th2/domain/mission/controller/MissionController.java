package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.code.MissionSuccessCode;
import com.example.umc9th2.domain.mission.converter.MissionConverter;
import com.example.umc9th2.domain.mission.dto.MissionChallengeResponse;
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

    //가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionChallengeResponse> challengeMission(
            @PathVariable Long missionId,
            @RequestParam Long userId
    ) {
        return ApiResponse.onSuccess(
                MissionSuccessCode.MISSION_CHALLENGE_SUCCESS,
                missionService.challengeMission(missionId, userId)
        );

    }
}