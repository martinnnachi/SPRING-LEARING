package com.example.annotations;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "Practise your back-hand volley";
    }
}
