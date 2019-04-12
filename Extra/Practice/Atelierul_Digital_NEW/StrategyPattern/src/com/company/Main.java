package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 4,  3, 6, 9, 8, 7, 1, 4, 5, 5, 2, 3, 6, 9, 8, 7, 1, 4, 5, 2,  3, 6, 9, 8, 7, 1, 4, 5, 3, 6, 9, 8, 7};
        Integer[] copy01OfArr = Arrays.copyOf(arr, arr.length);
        Integer[] copy02OfArr = Arrays.copyOf(arr, arr.length);

        displaySorted(BubbleSort.getInstance(), copy01OfArr);
        displaySorted(MergeSort.getInstance(), copy02OfArr);
    }

    private static void displaySorted(SortingStrategy strategy, Integer[] arr) {
        strategy.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
