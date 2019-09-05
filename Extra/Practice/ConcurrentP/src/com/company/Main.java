package com.company;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player one = new Player();
        Player two = new Player();

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(one.getChoice());
        System.out.println(two.getChoice());
    }
}

class Player extends Thread {
    private String choice;

    @Override
    public void run() {
        Random random = new Random();
        int value = random.nextInt(3);

        switch (value) {
            case 0: {
                choice = "Rock";
            }
            break;
            case 1: {
                choice = "Paper";
            }
            break;
            case 2: {
                choice = "Scissors";
            }
            break;
        }
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}

class RabbitThread extends Thread {
    int nr;

    RabbitThread(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        System.out.printf("Rabbit #%d is running.\n", nr);
    }
}

class RabbitRunnable implements Runnable {
    int nr;

    RabbitRunnable(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        System.out.printf("Rabbit #%d is running.\n", nr);
    }
}
