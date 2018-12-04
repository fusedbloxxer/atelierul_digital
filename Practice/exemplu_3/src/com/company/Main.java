package com.company;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Arrays.setAll;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Player player1 = new Player();
        Player player2 = new Player();

        player1.start();
        player2.start();

        player1.join();
        player2.join();

        printWinner(player1, player2);


    }

    private static void printWinner(Player player1, Player player2) {

        System.out.println("Player 1 chose: " + player1.option + " Player 2 chose: " + player2.option);

        if(player1.option.equals(player2.option)) System.out.print("Draw!");
            else {
                if((player1.option.equals("rock") && player2.option.equals("scissors")) ||
                        (player1.option.equals("scissors") && player2.option.equals("paper")))
                    System.out.print("Player 1 wins!");
                else System.out.print("Player 2 wins!");
            }
    }

    static class Player extends Thread {
        String option;// 0 - Rock, 1 - Paper, 2 - Scissors
        @Override
        public void run() {
            List<String> options = asList("paper", "rock", "scissors");
            Integer randomOptionIndex = new Random().nextInt(3);
            this.option = options.get(randomOptionIndex);
        }
    }
}


