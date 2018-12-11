package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Player player1 = new Player();
	    Player player2 = new Player();

	    int Rounds = 5;
	    while(Rounds-- != 0) {
	        player1.start();
	        player2.start();

	        if(!player1.isAlive() && !player2.isAlive()) {
	            if(player1.Move == player2.Move) {
                    player1.increment();
                    player2.increment();
                } else {
	                if(player1.Move.compareTo("Scissors")==0) {
                        if (player2.Move.compareTo("Paper") == 0)
                            player1.increment();
                        else player2.increment();
                    } else {

                    }
                }
            }
        }
    }
}
class Player extends Thread {
    Integer Score =0;
    String Move;

    public void increment() {
        this.Score++;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        int Option;
        Option = rnd.nextInt(3);
        switch(Option) {
            case 0: Move = "Scissors";
                break;
            case 1: Move = "Paper";
                break;
            case 2: Move = "Rock";
                break;
        }
    }
}
