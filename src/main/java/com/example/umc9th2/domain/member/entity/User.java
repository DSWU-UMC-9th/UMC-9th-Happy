package com.example.umc9th2.domain.member.entity;

import com.example.umc9th2.domain.mission.entity.UserMission;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthDate;

    @Column(length = 255)
    private String address;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String phone;

    // --- Relations ---
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserMission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserFoodPreference> foodPreferences = new ArrayList<>();

    // --- Builder ---
    @Builder
    private User(String name, String nickname, Gender gender, LocalDate birthDate,
                   String address, String email, String phone) {
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}
