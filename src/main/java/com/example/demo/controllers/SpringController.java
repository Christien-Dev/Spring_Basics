package com.example.demo.controllers;

import com.example.demo.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {


    Coach coach;

//    @Autowired  //Enable Setter Dependency Injection for the Coach
//    public void setCoach(@Qualifier("hockeyCoach") Coach coach) {   //Qualifier used if more than one potential bean exists for injection
//        this.coach = coach;
//    }

    @Autowired  //Enable Constructor Dependency Injection for the Coach
    SpringController(@Qualifier("soccerCoach") Coach coach){        //Used the soccerCoach implementation
        this.coach = coach;
    }

    @RequestMapping(value = "/dailyWorkout", method = RequestMethod.GET)
    String getDailyWorkout(){
        return coach.dailyWorkout();
    }
}
