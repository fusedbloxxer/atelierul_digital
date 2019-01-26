package com.company;

public class Main {

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

    public static void main(String[] args) {
        System.out.println(sleepIn(false, false));
    }
}
