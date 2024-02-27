package com.example.core.configs;

import com.example.core.implementations.BasketBallCoach;
import com.example.core.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean   //Takes an existing 3rd party class and expose it as a Spring bean available in other parts of code to be used
    public Coach basketBallCoach(){     //The bean id defaults to the method name, in order to access this bean in other code
        return new BasketBallCoach();   //the Coach variable must be named 'basketBallCoach' like the method
    }

}
