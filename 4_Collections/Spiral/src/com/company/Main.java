package com.company;

public class Main {

    private static void Spiral(int[][] m, int N){

        if(N == 1) System.out.println(1);
        else{

            int[][] COORDINATES = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
            int U = N - 1;
            int M = N * N;
            int i = 0, j = 0;

            while( M != 0 ){
                for(int index = 0; index < U; index++){
                    System.out.print(m[i][j] + " ");
                    
                }
            }


/*
            int S = N * N;
            boolean once = false;
            N--;
            int[][] COORDINATES = { {0, 1, N }, {1, 0, N}, {0, -1, N}, {-1, 0, N - 1} };
            int DIRECTION = 0, i = 0, j = 0;

            if( (N + 1) % 2 == 1){

                while(S!=0){

                    for(int index = 0; index < COORDINATES[DIRECTION][2]; index++){

                        //if(i >= 0 && j >= 0 && j <= N && i <= N)
                        System.out.print(m[i][j] + " ");
                        i = i + COORDINATES[DIRECTION][0];
                        j = j + COORDINATES[DIRECTION][1];
                        S--;
                    }

                    COORDINATES[DIRECTION++][2]--;

                    if(DIRECTION == 4) {DIRECTION = 0; once = true; }

                    if(DIRECTION > 0 && once == true){
                        if(DIRECTION == 1 || DIRECTION == 2)COORDINATES[DIRECTION][2]--;
                    }
                    System.out.println();
                }
            }
            else {

                while(COORDINATES[0][2] > 0 || COORDINATES[1][2] > 0 || COORDINATES[2][2] > 0 || COORDINATES[3][2] > 0){

                    for(int index = 0; index < COORDINATES[DIRECTION][2]; index++){
                        System.out.print(m[i][j] + " ");
                        i = i + COORDINATES[DIRECTION][0];
                        j = j + COORDINATES[DIRECTION][1];
                    }

                    COORDINATES[DIRECTION++][2]--;
                    if((DIRECTION == 0) && once == true) COORDINATES[DIRECTION][2]--;

                    if(DIRECTION == 4) {DIRECTION = 0; once = true; }

                    System.out.println();
                }
            }*/
        }

    }
    //Inefficient memory-wise. Double size of the matrix.
    private static void Spiral_2(int[][] m, int N)
    {
        int[][] T = new int[N][N];
        int[][] Dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        int index = 0, i = 0, j = 0, L= N;
        N *= N;
        while(N != 0) {
            System.out.print(m[i][j] + " ");
            T[i][j] = -1;
            int y = i + Dir[index][0], x = j + Dir[index][1];

            if(x >= L || x < 0 || y < 0 || y >= L || T[y][x] == -1) {
                index++;
                if(index == 4)
                    index = 0;

                i = i + Dir[index][0];
                j = j + Dir[index][1];
            } else {
                i = y;
                j = x;
            }
            N--;
        }
    }

    public static void main(String[] args) {

        int N = 8, count = 10;
        int[][] U = new int[N][N];

        for(int i =0; i < N; i++){
            for(int j = 0; j < N; j++){
                U[i][j] = count++; System.out.print(U[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        Spiral_2(U, N);
    }
}
