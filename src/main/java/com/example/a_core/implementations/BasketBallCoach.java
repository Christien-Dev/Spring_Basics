package com.example.a_core.implementations;

import com.example.a_core.interfaces.Coach;
import org.springframework.context.annotation.Lazy;

@Lazy   //By default, all beans are initialized when you start your app, lazy makes it so its only initialized when needed
public class BasketBallCoach implements Coach {

    public BasketBallCoach() {
        System.out.println("Initialized Bean: " + getClass().getName());
    }

    @Override
    public String dailyWorkout() {
        return "shoot some 3-pointers";
    }

}
