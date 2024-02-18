package com.example.core.implementations;

import com.example.core.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("Initialized Bean: " + getClass().getName());
    }

    @Override
    public String dailyWorkout() {
        return "Go to bat and hit the ball";
    }
}
