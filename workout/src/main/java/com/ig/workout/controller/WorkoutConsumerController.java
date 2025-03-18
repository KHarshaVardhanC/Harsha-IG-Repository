package com.ig.workout.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ig.workout.model.Workout;

@RestController
public class WorkoutConsumerController {

    @Autowired 
    private RestTemplate restTemplate;

    @PostMapping("/consume/add")
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {
        return restTemplate.postForEntity("http://localhost:8080/api/workouts/add", workout, Workout.class);
    }

    @GetMapping("/consume/all")
    public ResponseEntity<Workout[]> getAllWorkouts() {
        return restTemplate.getForEntity("http://localhost:8080/api/workouts/all", Workout[].class);
    }
}
