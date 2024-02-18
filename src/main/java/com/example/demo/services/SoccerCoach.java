package com.example.demo.services;

import com.example.demo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Take some penalty shots at the goal keeper";
    }
}
