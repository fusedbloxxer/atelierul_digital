package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws  InterruptedException{
	    int nrOfPhilosophers = 5;
        List<Philosopher> philosophers = new ArrayList<>();
        List<Chopstick> chopsticks = new ArrayList<>();
        for(int i=0; i < nrOfPhilosophers;i++) {
            chopsticks.add(new Chopstick());
        }

        for(int  i=0i<nrOfPhilosophers;i++) {
            Chopstick left = chopsticks.get(i);
            Chopstick right = chopsticks.get((i + 1 ) % nrOfPhilosophers);
            philosophers.add(new Philosopher("p" + (i + 1), left ,right));
        }

        for(Philosopher philosopher: philosophers){
            philosopher.start();
        }

        for(Philosopher philosopher: philosophers) {
            philosopher.join();
        }
    }

    static class Philosopher extends Thread{
        private String id;
        private Chopstick left, right;
        public Philosopher(String id, Chopstick left, Chopstick right) {
            this.id = id;
            this.left = left;
            this. right = right;
        }
        @Override
        public void run() {
            while(true) {
                synchronized (left) {
                    synchronized (right) { // este posibil ca cineva sa ia lucrul altcuiva
                        //sa evitam sa folosim double synchronize
                        //folosim o interfata lock, nu mai avem blocaj, dam drumul la lock dar este riscul sa ajungem in livelock
                        //
                        eat();
                        rest();
                    }
                }

                eat();
                rest();
            }
        }

        private void rest() {
            Thread.sleep(100);
        }

        private void eat() {
            System.out.println(" I ate something ! ");
        }
    }

    static class Chopstick {

    }
}
