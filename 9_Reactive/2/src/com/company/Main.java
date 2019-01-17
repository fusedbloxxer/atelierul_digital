package com.company;

import java.util.concurrent.Flow;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    // reactor
        Flux<Integer> f = Flux.just(1,2,3,4);
	    f.map(e -> e * 2);
	     .map(e -> e + 7)
                .filter(e -> e %3==0)
                ;
	     f.subscribe(e -> System.out.println("I just received:" + e));
    }
}
