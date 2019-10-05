package com.company;

public class Main {

    public static int test() { //what will this method return ?
        try {
            //throw new RuntimeException("something bad happened");
            return 0;
        } catch(Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }


    public static void main(String[] args) {
        System.out.println(test());
    }
}
