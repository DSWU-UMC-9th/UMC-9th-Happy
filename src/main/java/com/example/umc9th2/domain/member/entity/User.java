package com.example.umc9th2.domain.member.entity;

import com.example.umc9th2.domain.mission.entity.UserMission;
import com.example.umc9th2.domain.review.entity.Review;
import com.example.umc9th2.global.auth.enums.Role;
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

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthDate;

    @Column(length = 255)
    private String address;

    @Column(length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 20)
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
    public User(String email, String password, String name, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public void updatePasswordAndRole(String password, Role role) {
        this.password = password;
        this.role = role;
    }
}
