package com.company;

public class Main {

    private static void Bell_1(int N){
        if(N >= 1) {
            System.out.println(1);
            if(N >= 2){
                System.out.println(1 + " " + 2);
                if(N > 2){
                    int[][] myList = new int[2][N]; // 2 * N (Memory Complexity)
                    myList[0][0] = 1;
                    myList[1][0] = 1; myList[1][1] = 2;

                    N -= 2;int count = 2;
                    while(N-- != 0){
                        //First Copy Operation
                        myList[0][0] = myList[1][0];
                        myList[1][0] = myList[1][count - 1];

                        System.out.print(myList[1][0] +" ");

                        for(int index = 1; index <= count; index++){
                            //Push the (previous)elements on the second row above then calculate the new values.
                            myList[0][index] = myList[1][index];
                            myList[1][index] = myList[0][index - 1] + myList[1][index - 1];

                            //Print the (new)elements placed on the second row
                            System.out.print(myList[1][index] + " ");
                        }

                        count++;
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int N = 6;
        Bell_1(N);
    }
}
