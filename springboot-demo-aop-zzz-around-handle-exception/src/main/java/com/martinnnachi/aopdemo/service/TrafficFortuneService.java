package com.martinnnachi.aopdemo.service;


import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class TrafficFortuneService {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";


    public String getFortune() {

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep( 5 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // return a fortune


        return ANSI_BLACK + ANSI_YELLOW_BACKGROUND + "Expect heavy traffic this morning" + ANSI_RESET;
    }

    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException( ANSI_BLACK + ANSI_RED_BACKGROUND + "Major accident! Highway closed" + ANSI_RESET );
        }

        return getFortune();
    }
}
