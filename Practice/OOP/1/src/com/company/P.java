package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P {
    public static void main(String[] args) {
        int nrOfPhilosophers = 11;
        List<Chopstick> chopsticks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();
        for(int i = 0; i < nrOfPhilosophers; i++) {
            chopsticks.add(new Chopstick(i));
        }
        for(int i = 0; i < nrOfPhilosophers; i++) {
            Chopstick left = chopsticks.get(i);
            Chopstick right = chopsticks.get((i + 1) % nrOfPhilosophers);
            philosophers.add(new Philosopher(i, left , right));
        }
        for(Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
    static class Chopstick {
        private Lock lock = new ReentrantLock();
        int i;
        public Chopstick(int i) {
            this.i = i;
        }
        public boolean hold() { lock.lock(); return true; }
        public void release() { lock.unlock(); }
    }
    static class Philosopher extends Thread {
        private String name;
        private int i;
        private Chopstick left, right;
        public Philosopher(int i, Chopstick left, Chopstick right) {
            super("P" + i);
            this.name = "P" + i;
            this.left = left;
            this.right = right;
        }
        @Override
        public void run() {
            while(true) {
                eat();
                think();
            }
        }
        private void think() {
            System.out.println(name + "is thinking");
            try{
                sleep(100);
            } catch (Exception ex) {}
        }
        private void eat() {
            if(left.hold()) {
                if(right.hold()) {
                    System.out.println(name + "is eating");
                    right.release();
                }
                left.release();
            }
        }
    }
}
