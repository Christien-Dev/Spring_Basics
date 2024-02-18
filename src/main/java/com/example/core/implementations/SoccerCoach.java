package com.example.core.implementations;

import com.example.core.interfaces.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //By default, scope is singleton meaning a single shared instance of this bean SoccerCoach
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //This scope will create a new bean instance for each container request, @lazy initialized by default
public class SoccerCoach implements Coach {

    public SoccerCoach() {
        System.out.println("Initialized Bean: " + getClass().getName());
    }

    @PostConstruct  //Custom code for bean initialization, called regardless of scope
    public void init(){
        System.out.println("Starting up...");
    }

    @Override
    public String dailyWorkout() {
        return "Take some penalty shots at the goal keeper";
    }

    @PreDestroy     //Custom code for bean destruction, for prototype bean this will not be called (So here in SoccerCoach, it's not called)
    public void destroy(){
        System.out.println("Tearing down....");
    }
}
