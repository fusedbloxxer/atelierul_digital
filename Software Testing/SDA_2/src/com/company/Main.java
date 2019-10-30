package com.company;

import javax.naming.SizeLimitExceededException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            nr_mare numar = nr_mare.citire();
            numar.afisare();
        } catch (SizeLimitExceededException e) {
            e.printStackTrace();
        }
    }
}

class nr_mare {
    public static final int MAX_SIZE = 100;
    private LinkedList<Integer> list;
    private boolean isNegative;

    private nr_mare() {
        isNegative = false;
        list = new LinkedList<>();
    }

    private nr_mare(Integer integer) throws SizeLimitExceededException {
        list = new LinkedList<>();
        isNegative = false;

        if (integer < 0) {
            isNegative = true;
            integer *= -1;
        }

        while (integer != 0) {
            list.addFirst(integer % 10);
            integer /= 10;
            if (list.size() > MAX_SIZE) {
                throw new SizeLimitExceededException("MAX_SIZE IS: " + MAX_SIZE);
            }
        }
    }

    public void afisare() {
        if (list.size() > 0) {
            if (list.size() == 1 && list.get(0) == 0) ; // Don't print sign for 0
            else if (isNegative) {
                System.out.print("-");
            }
        }
        list.forEach(System.out::print);
    }

    public static void adunare(nr_mare a, nr_mare b) {

    }

    public static nr_mare citire() throws SizeLimitExceededException {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        nr_mare number = new nr_mare();

        if (!Character.isDigit(string.charAt(0))) {
            if (string.charAt(0) == '-') {
                number.isNegative = true;
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                number.list.addLast(string.charAt(i) - '0');
                if (number.list.size() > MAX_SIZE) {
                    throw new SizeLimitExceededException("MAX_SIZE IS: " + MAX_SIZE);
                }
            }
        }

        return number;
    }
}
