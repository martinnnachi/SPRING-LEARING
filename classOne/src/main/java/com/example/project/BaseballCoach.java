package com.example.project;

public class BaseballCoach implements Coach {

    private final FortuneService fortuneService;

    // Constructor Injection
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spent 30 minutes in batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}