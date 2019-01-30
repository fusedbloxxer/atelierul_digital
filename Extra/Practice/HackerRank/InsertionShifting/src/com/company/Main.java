package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static int insertionSort(int[] arr) {
        int shiftSum = 0;
        int index = 1;
        while(index < arr.length) {
            shiftSum += shiftSortAtIndex(index, arr);
            index++;
        }
        return shiftSum;
    }
    private static int shiftSortAtIndex(int index, int arr[]) {
        int shifts = 0;
        while(index > 0 && arr[index] < arr[index - 1]) {
            int aux = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = aux;

            index--;
            shifts++;
        }
        return shifts;
    }
    public static void main(String[] args) throws IOException {
        try(Scanner s = new Scanner(new BufferedReader(new FileReader("test.txt")))) {
            int t = s.nextInt();
            while(t-- != 0) {
                int n = s.nextInt();
                int arr[] = new int[n];
                for(int i = 0; i < n; i++) {
                    arr[i] = s.nextInt();
                }
                System.out.println(insertionSort(arr));
            }
        }
    }
}