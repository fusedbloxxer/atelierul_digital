package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();

            System.out.println(getMaxValue(n, k));
        }

        scanner.close();
    }



    public static int getMax(int n, int k) {
        int maxValue = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int value = i & j;
                if (value < k && maxValue < value){
                    maxValue = value;
                }
            }
        }

        return maxValue;
    }

    public static int getValue(int x, int k, int a, int b) {
        if (a < b) {
            int middle = a + (b - a) / 2;
            int result = middle & x;
            if (result == k - 1) return result;
            else if (result < k) return getValue(x, k, middle + 1, b);
            else return getValue(x, k, a, middle - 1);
        } return x & (a + (b - a) / 2);
    }

    public static int getMaxValue(int n, int k) {
        int maxValue = 0;

        for (int i = 1; i < n; i++) {
            int value = getValue(i, k, 1, n);
            if (value < k && maxValue < value) {
                maxValue = value;
            }
        }

        return maxValue;
    }
}
