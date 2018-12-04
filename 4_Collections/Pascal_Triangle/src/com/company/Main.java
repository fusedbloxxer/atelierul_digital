package com.company;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //This method uses a Primitive Matrix to store and generate Pascal's Triangle. (N^2 Memory Complexity)
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
        System.out.println(Duration.between(start, stop));
        System.out.println("Size is: " + n*n);
    }

    private static void WhiteSpaces(int fillSpace) {
        while(fillSpace-- != 0)System.out.print(" ");
    }

    //This method creates a list, storing and calculating the values for each line. ( [N / 2 + 1] Space Complexity )
     private static void Pascal_2(int n){

         Instant start = Instant.now();
         n++;

        List<Integer> Triangle = new ArrayList<>();
        int index = 0; int Size = 1;
        Triangle.add(1);
        WhiteSpaces(n-1);
        System.out.println(1);

        for(int i = 2; i <= n; i++){
            WhiteSpaces(n - i);
            //Print half of the line
            while(index < Size){
                System.out.print(Triangle.get(index++) + " ");
            }
            index--;
            // If the line is even add a new element for the next line
            if(i % 2 == 0){
                Triangle.add(Triangle.get(index) * 2);
                Size++;
                // Print the other half of the line
                while(index >= 1){
                    System.out.print(Triangle.get(index) + " "); // Print the element
                    Triangle.set(index, Triangle.get(index--) + Triangle.get(index)); //  Update the line backwards
                }
            }else { // If the line is uneven skip the last element then print the rest of the half.
                if(Size > 1){
                Triangle.set(index, Triangle.get(index--) + Triangle.get(index));
                while(index>=1) {
                    System.out.print(Triangle.get(index) + " "); // Print the element
                    Triangle.set(index, Triangle.get(index) + Triangle.get(index - 1)); // Update the list backwards
                    index--;
                    }
                }
            }

            System.out.println(1);
        }

         Instant stop = Instant.now();
         System.out.println(Duration.between(start, stop));
         System.out.println("Size is: " + Triangle.size());
    }

    public static void main(String[] args) {

        int n = 100;

        Pascal_1(n);
        Pascal_2(n); // Better memory usage, worse performance.
    }
}
