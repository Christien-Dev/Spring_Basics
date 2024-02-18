package com.example.demo.services;

import com.example.demo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Go to bat and hit the ball";
    }
}
