package com.ig.workout.repository;

import org.springframework.data.repository.CrudRepository;

import com.ig.workout.model.Workout;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
}
