package com.Java.Collections.day11;

import java.util.Random;

public class Advisor {
    public static void main(String[] args) {
        String[] advices = {
            "Never begin to stop and never stop to begin.",
            "Only destination isn’t important, one should enjoy the journey.",
            "Impossible itself says 'I am possible'.",
            "Keep moving forward and never look back.",
            "Success is not the key to happiness. Happiness is the key to success.",
            "Believe in yourself and all that you are."
        };

        int randomIndex = getRandomIndex(advices.length);

        System.out.println(advices[randomIndex]);
    }

    public static int getRandomIndex(int length) {
        return (int) (Math.random() * length);
    }
}
