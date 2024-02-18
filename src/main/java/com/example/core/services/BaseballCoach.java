package com.example.core.services;

import com.example.core.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Go to bat and hit the ball";
    }
}
