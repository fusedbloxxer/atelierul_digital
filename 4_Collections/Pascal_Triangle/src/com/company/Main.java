package com.company;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Main {

    private static void Pascal_1(int n){

        Instant start = Instant.now();
        int[][] Triangle = new int[n][n];
        for(int i = 0; i < n; i++)
            Triangle[0][i]=Triangle[i][0]=1;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                Triangle[i][j] = Triangle[i - 1][j] + Triangle[i][j - 1];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i + j <= n)System.out.print(Triangle[i][j] + " ");
            }
            System.out.println();
        }

        Instant stop = Instant.now();
        System.out.println(Duration.between(stop, start));
    }

    private static void WhiteSpaces(int fillSpace){
        while(fillSpace-- != 0)System.out.print(" ");
    }

     private static void Pascal_2(int n){

         Instant start = Instant.now();
         n++;

        ArrayList<Integer> Triangle = new ArrayList<>();
        int index = 0; int Size = 1;
        Triangle.add(1);
        WhiteSpaces(n-1);
        System.out.println(1);

        for(int i = 2; i <= n; i++){

            WhiteSpaces(n - i);
            while(index < Size){
                System.out.print(Triangle.get(index++) + " ");
            }
            index--;
            if(i % 2 == 0){
                Triangle.add(Triangle.get(index) * 2);
                Size++;
                while(index >= 1){
                    System.out.print(Triangle.get(index) + " ");
                    Triangle.set(index, Triangle.get(index--) + Triangle.get(index));
                }
            }else {
                if(Size > 1){
                Triangle.set(index, Triangle.get(index--) + Triangle.get(index));
                while(index>=1) {
                    System.out.print(Triangle.get(index) + " ");
                    Triangle.set(index, Triangle.get(index) + Triangle.get(index - 1));
                    index--;
                    }
                }
            }

            System.out.println(1);
        }

         Instant stop = Instant.now();
         System.out.println(Duration.between(stop, start));

    }
/*
    private static void Pascal_3(int n){
        Instant start = Instant.now();

        n++;
        int[] myArray = new int[n/2 + 1]; myArray[0] = 1;
        int index = 0, Size = 1;

        for(int i = 1; i <= n; i++){
            WhiteSpaces(n - i);
            while(index < Size){
                System.out.print(myArray[index++] + " ");
            }

            if(i % 2 == 0){

                myArray[Size++] = myArray[index-- - 1] * 2;
                while(index >= 1){
                    System.out.print(myArray[index] + " ");
                    myArray[index] = myArray[index] + myArray[--index];
                }
                System.out.println(1);
            }else {
                if(Size >= 2){
                    index-=2;
                    while(index >= 1){
                        System.out.print(myArray[index] + " ");
                        myArray[index] = myArray[index--] + myArray[index];
                    }
                    System.out.println(1);

                }else {System.out.println();index--;}
            }

        }

        Instant stop = Instant.now();
        System.out.println(Duration.between(stop, start));
    }
*/
    public static void main(String[] args) {

        int n = 10;

        //Pascal_3(n);
        //System.out.println();
        Pascal_2(n);
        System.out.println();
        Pascal_1(n);
    }
}
