package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
    1 Given the following static integer variable:     public static long v = 0;.
    Start 5_000 threads so that each thread will increase the v value.
    Each thread will have a loop from 1 to 1_000_000 and for each iteration it will do a v++.
    5_000 threads, each increases the v by 1 for 1_000_000 iterations => at the end of application, v should have value 5_000_000_000.
    */

    public static long v = 0;

    public static void main(String[] args) throws InterruptedException {
        List<myThread> threadList = new ArrayList<>();

        System.out.println("Before: " + v);

        for(int index = 0; index < 5_000; index++) {
            threadList.add(new myThread());
        }

        for(int index = 0; index < 5_000; index++) {
            threadList.get(index).start();
            threadList.get(index).join();
        }

        System.out.println("After: " + v);
    }
}
class myThread extends Thread {
    @Override
    public void run() {
        for(int index = 1; index <= 1_000_000; index++) {
            Main.v++;
        }
    }
}