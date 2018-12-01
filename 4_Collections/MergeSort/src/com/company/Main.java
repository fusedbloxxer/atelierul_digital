package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;

public class Main {

    private static void readArray(int[] Array, String FileName, int N){
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(FileName)))){
            int index = -1;

            while(scanner.hasNext() && index++ < N){
                Array[index] = scanner.nextInt();
            }

        }catch (IOException ex){
            System.out.println("Error!! " + ex.getMessage());
        }
    }

    private static int[] MergeSort(int[] a, int[] b){

        int N1 = a.length, N2 = b.length;
        int[] Sorted = new int[N1 + N2];
        int i = 0, j = 0, k = 0;
        while(i < N1 && j < N2){
            if(a[i] < b[j]){
                Sorted[k++] = a[i++];
            } else {
                Sorted[k++] = b[j++];
            }
        }
        while(i < N1){
            Sorted[k++] = a[i++];
        }
        while(j < N2){
            Sorted[k++] = b[j++];
        }

        for(i = 0; i < k; i++)System.out.print(Sorted[i] + " ");
        System.out.println();

        return Sorted;
    }

    public static void main(String[] args) {

        int N = 100;
        int[] arr1, arr2;
        arr1 = new int[N];
        arr2 = new int[N];
        readArray(arr1,"array1.txt", N);
        readArray(arr2,"array2.txt", N);

        MergeSort(arr1, arr2);

    }
}
