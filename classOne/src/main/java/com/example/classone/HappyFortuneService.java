package com.example.classone;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        String[] fortune = {"Well done bro!",
                "You did it!",
                "Fortune favours the bold!",
                "You're almost there!",
                "Nothing can stop you!"};

        Random generator = new Random();
        int randomIndex = generator.nextInt( fortune.length );
        return fortune[randomIndex];
    }


}
