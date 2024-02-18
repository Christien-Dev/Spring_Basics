package com.example.core.services;

import com.example.core.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Take some penalty shots at the goal keeper";
    }
}
