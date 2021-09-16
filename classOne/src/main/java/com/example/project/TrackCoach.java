package com.example.project;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    // Constructor Injection
    public TrackCoach(FortuneService myFortuneService) {
        fortuneService = myFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    // add init-method
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    // add destroy-method
    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }


}
