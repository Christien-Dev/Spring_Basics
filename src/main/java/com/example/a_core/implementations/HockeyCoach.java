package com.example.a_core.implementations;

import com.example.a_core.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
//@Primary    //If multiple beans are available for dependency injection with no @Qualifier, this bean is set as primary to be injected
public class HockeyCoach implements Coach {

    public HockeyCoach() {
        System.out.println("Initialized Bean: " + getClass().getName());
    }

    @Override
    public String dailyWorkout() {
        return "Do some blue line/red line drills";
    }
}
