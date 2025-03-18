package com.ig.workout.dto;

import jakarta.validation.constraints.*;

public class WorkoutDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private int duration;

    @Min(value = 1, message = "Calories burnt must be at least 1")
    private int caloriesBurnt;

    @NotBlank(message = "Category is required")
    private String category;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public void setCaloriesBurnt(int caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
