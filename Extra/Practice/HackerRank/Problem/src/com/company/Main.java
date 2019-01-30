package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);

        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) < b.get(i)) {
                result.set(0, result.get(0) + 1);
            } else if(a.get(i) > b.get(i)) {
                result.set(1, result.get(1) + 1);
            }
        }

        return result;
    }

    static void plusMinus(int[] arr) {
        int positive = 0, negative = 0, zero = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                negative++;
            } else if (arr[i] > 0) {
                positive++;
            } else {
                zero++;
            }
        }
        System.out.format("%.6f%n%.6f%n%.6f%n", (float)positive/arr.length, (float)negative/arr.length, (float)zero/arr.length);
    }

    static void staircase(int n) {
        for(int i = 0; i < n ; i++) {
            int k = n - i - 1;
            while(k-- != 0) {
                System.out.print(" ");
            }
            k = i + 1;
            while(k-- != 0) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);

    }

    static int birthdayCakeCandles(int[] ar) {
        long max  = ar[0];
        int count = 1;
        for(int i = 0; i < ar.length; i++) {
            if(max < ar[i]) {
                max   = ar[i];
                count = 1;
            } else if (max == ar[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 1, 3};
        System.out.println(birthdayCakeCandles(a));
    }
}
