package com.example.outercomponent;

import com.example.demo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {

    /*
    * If we use this implementation of Coach in the controller located in the demo package we will get an error
    * Only works if we component scan both the 'componentscan' & 'demo' package on the @SpringBootApplication - Inquire why?
    * @SpringBootApplication(
	*       scanBasePackages = {"com.example.componentscan", "com.example.demo"}
    * )
    * */

    @Override
    public String dailyWorkout() {
        return "Dribble the ball around the court";
    }
}
