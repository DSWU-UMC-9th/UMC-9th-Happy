package com.example.umc9th2.domain.member.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "foodType")
public class FoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "food_name", length = 50, nullable = false)
    private String foodName;

    @OneToMany(mappedBy = "foodType")
    private List<UserFoodPreference> userPreferences = new ArrayList<>();
}