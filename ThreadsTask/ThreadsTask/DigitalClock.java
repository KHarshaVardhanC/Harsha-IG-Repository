package com.Java.Collections.day11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends Thread {
    public void run() {
        try {
            while (true) {
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println(sdf.format(now));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DigitalClock clock = new DigitalClock();
        clock.start();
    }
}
