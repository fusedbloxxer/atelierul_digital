package com.company;

public class Main {

    private static void Zig_Zag(int[] myArray, int[] Sol, int K, int Ascending) {
        if(K < myArray.length){

            for(int index = 0; index < myArray.length; index++){

                boolean check = true;
                Sol[K] = myArray[index];

                if(K > 0 && (Sol[K] - Sol[K - 1]) * Ascending > 0) check = false;
                for(int index_2 = K - 1; index_2 >= 0; index_2--){
                    if(Sol[index_2] == Sol[K]){
                        index_2 = 0; check = false;
                    }
                }

                if(check)
                    Zig_Zag(myArray, Sol, K + 1, Ascending * -1);
            }
        } else {

            for(int index = 0; index < K; index++)
                System.out.print(Sol[index] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        int[] arr2 = {1, 1, 1, 1};
        int[] Aux = new int[java.lang.Math.max(arr.length, arr2.length)];

        Zig_Zag(arr, Aux, 0, 1);


    }
}
