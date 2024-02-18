package com.example.demo.services;

import com.example.demo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Do some blue line/red line drills";
    }
}
