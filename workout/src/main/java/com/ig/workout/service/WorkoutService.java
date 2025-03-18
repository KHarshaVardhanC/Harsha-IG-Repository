package com.ig.workout.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.workout.model.Workout;
import com.ig.workout.repository.WorkoutRepository;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;
    

    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return (List<Workout>) workoutRepository.findAll();
    }
}
