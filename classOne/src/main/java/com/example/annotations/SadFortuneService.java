package com.example.annotations;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Today was supposed to be a sad day, but i'm always happy!";
    }
}
