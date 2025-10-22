package com.example.umc9th2.domain.mission.entity;

import com.example.umc9th2.domain.store.entity.Store;
import com.example.umc9th2.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "mission")
public class Mission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(length = 100, nullable = false)
    private String missionName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer rewardPoint;

    @OneToMany(mappedBy = "mission")
    private List<UserMission> userMissions = new ArrayList<>();
}

