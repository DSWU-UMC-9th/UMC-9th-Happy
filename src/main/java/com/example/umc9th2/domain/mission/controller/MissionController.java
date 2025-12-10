package com.example.umc9th2.domain.mission.controller;

import com.example.umc9th2.domain.mission.code.MissionSuccessCode;
import com.example.umc9th2.domain.mission.converter.MissionConverter;
import com.example.umc9th2.domain.mission.dto.MissionChallengeResponse;
import com.example.umc9th2.domain.mission.dto.MissionResDTO;
import com.example.umc9th2.domain.mission.entity.Mission;
import com.example.umc9th2.domain.mission.entity.UserMission;
import com.example.umc9th2.domain.mission.service.MissionService;
import com.example.umc9th2.domain.review.code.ReviewSuccessCode;
import com.example.umc9th2.global.apiPayload.ApiResponse;
import com.example.umc9th2.global.validator.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/in-progress")
    @Operation(summary = "진행중인 미션 목록 조회", description = "사용자가 진행 중인 미션을 페이지 단위로 조회합니다.")
    public ApiResponse<MissionResDTO.MissionListResult> getInProgressMissions(
            @RequestParam Long userId,
            @ValidPage @RequestParam int page
    ) {
        MissionResDTO.MissionListResult result = missionService.getInProgressMissions(userId, page);
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_READ_SUCCESS, result);
    }

    // 특정 가게 미션 전체 조회
    @GetMapping("/store/{storeId}")
    @Operation(
            summary = "특정 가게 미션 전체 조회",
            description = "storeId에 해당하는 특정 가게의 모든 미션 목록을 조회합니다."
    )
    public ResponseEntity<List<Mission>> getMissionsByStore(@PathVariable Long storeId) {
        List<Mission> missions = missionService.getMissionsByStore(storeId);
        return ResponseEntity.ok(missions);
    }

}