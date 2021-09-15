package com.example.classone;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        String[] fortune = new String[3];
        fortune[0] = "Well done bro!";
        fortune[1] = "You did it!";
        fortune[2] = "Fortune favours the bold!";

        Random generator = new Random();
        int randomIndex = generator.nextInt( fortune.length );
        return fortune[randomIndex];
    }


}
