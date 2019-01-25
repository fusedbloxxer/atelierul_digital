package com.company;

public class Main {

    public static int superPow(int a, int[] b) {
        double f = 0;
        for(int i = 0; i < b.length; i++) {
            f = (int)(f + b[i] * Math.pow(10, b.length - 1 - i));
        }
        return (int)Math.pow(a, f) % 1337;
    }

    public static void main(String[] args) {
        int a[] = {2, 0, 0};
        System.out.println(superPow(2147483647, a));
    }
}
