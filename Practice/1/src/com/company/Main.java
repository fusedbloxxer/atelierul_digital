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
	    int nrOfThreads = 5_000;
	    List<MyThread> threads = new ArrayList<>();
        //create threads
	    for(int i=0;i<nrOfThreads; i++) {
            threads.add(new MyThread());
        }
	    //start threads
        for(MyThread thread: threads) {
            thread.start();
        }
        //wait for all threads to finish execution
        for(MyThread thread: threads) {
            thread.join();
        }

        System.out.print(v);
    }

    static class MyThread extends Thread {
        @Override
        public void run() {

            increment();
        }

        static synchronized void increment() {
            for(int i =0;i<1_000_000;i++) {
                v++;
            }
        }
    }
}
