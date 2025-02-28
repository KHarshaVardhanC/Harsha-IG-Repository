package com.Java.Collections.day11;


class ConferenceRoom {
    private boolean isAvailable = true;

    public synchronized boolean checkAvailability() {
        return isAvailable;
    }

    
    public synchronized void bookRoom() {
        isAvailable = false;
    }

    public synchronized void releaseRoom() {
        isAvailable = true;
    }
}

class ConferenceRoomBookingJob implements Runnable {
    private ConferenceRoom room;

    public ConferenceRoomBookingJob(ConferenceRoom room) {
        this.room = room;
    }

    @Override
    public void run() {
        String managerName = Thread.currentThread().getName();
        System.out.println(managerName + " is trying to book the room.");

        synchronized (room) {
            if (room.checkAvailability()) {
                System.out.println(managerName + " has successfully booked the room.");
                room.bookRoom();

                try {
                    Thread.sleep(2000); 
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(managerName + " has finished the meeting.");
                room.releaseRoom();
            } else {
                System.out.println(managerName + " could not book the room as it is already booked.");
            }
        }
    }
}

public class ConferenceRoomBookingSystem {
    public static void main(String[] args) {
        ConferenceRoom room = new ConferenceRoom();

        Thread manager1 = new Thread(new ConferenceRoomBookingJob(room), "Manager 1");
        Thread manager2 = new Thread(new ConferenceRoomBookingJob(room), "Manager 2");

        manager1.start();
        manager2.start();
    }
}
