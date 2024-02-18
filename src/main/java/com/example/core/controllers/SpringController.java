package com.example.core.controllers;

import com.example.core.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {


    Coach coach;
    Coach coachTwo;

//    @Autowired  //Enable Setter Dependency Injection for the Coach
//    public void setCoach(@Qualifier("hockeyCoach") Coach coach) {   //Qualifier used if more than one potential bean exists for injection
//        this.coach = coach;
//    }

    @Autowired  //Enable Constructor Dependency Injection for the Coach
    SpringController(@Qualifier("soccerCoach") Coach coach, @Qualifier("soccerCoach") Coach coachTwo){        //Used the soccerCoach implementation
        this.coach = coach;
        this.coachTwo = coachTwo;
    }

    @RequestMapping(value = "/dailyWorkout", method = RequestMethod.GET)
    String getDailyWorkout(){
        return coach.dailyWorkout();
    }

    @RequestMapping(value = "/getScope", method = RequestMethod.GET)
    String getCoachScope(){
        return "Comparing coaches: coach == coachTwo? " + (coach == coachTwo ? "true, singleton scope enabled" : "false, prototype scope enabled");
    }
}
