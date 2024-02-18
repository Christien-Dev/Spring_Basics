package com.example.core.services;

import com.example.core.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Do some blue line/red line drills";
    }
}
