package com.example.annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private final String[] arr = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good fortune",
            "Happy wife, happy life!",
            "I'm blessed to be a blessing!",
            "Talk your way to the top!"
    };

    @Override
    public String getFortune() {
        Random generator = new Random();
        int index = generator.nextInt( arr.length );
        return arr[index];
    }
}
