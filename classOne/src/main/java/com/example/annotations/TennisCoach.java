package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

    // field injection
    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(" >> TennisCoach: inside default constructor <<");
    }

    // define my init method
    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("TennisCoach: doMyStartUpStuff()");
    }

    // define destroy method
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("TennisCoach: doMyCleanUpStuff()");
    }

//    // constructor injection
//    @Autowired
//    public TennisCoach(FortuneService theFortuneService) {
//        this.fortuneService = theFortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practise your back-hand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    // setter injection
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(" >> TennisCoach: inside setFortuneService() method <<");
//        this.fortuneService = fortuneService;
//    }
}
