package com.company;

public class Main {

    //Inefficient memory-wise. Double size of the matrix. ( 2 * N^2 )
    private static void Spiral(int[][] m, int N)
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

        Spiral(U, N);
    }
}
