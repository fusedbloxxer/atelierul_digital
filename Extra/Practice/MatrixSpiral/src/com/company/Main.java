package com.company;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String[][] matrix = new String[3][];
        matrix[0] = new String[]{"Andrei", "are", "mere"};
        matrix[1] = new String[]{"parere", "ai?", "foarte"};
        matrix[2] = new String[]{"ce", ", ", "gustoase"};

        Utilities.getInstance().spiral(matrix);
    }
}

class Utilities <T> {
    private static Utilities INSTANCE;
    private Utilities() {}
    public static Utilities getInstance() {
        if (INSTANCE == null) {
            synchronized (Utilities.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Utilities();
                }
            }
        }
        return INSTANCE;
    }

    public <T> void spiral(T[][] matrix) {
        int i1 = 0, i2 = matrix.length - 1, j1 = 0, j2 = matrix.length - 1;

        while (i1 <= i2 && j1 <= j2) {
            for (int j = j1; j <= j2; j++) {
                System.out.print(matrix[i1][j] + " ");
            }

            for (int i = i1 + 1; i <= i2; i++) {
                System.out.print(matrix[i][j2] + " ");
            }

            for (int j = j2 - 1; j >= j1; j--) {
                System.out.print(matrix[i2][j] + " ");
            }

            for (int i = i2 - 1; i > i1; i--) {
                System.out.print(matrix[i][j1] + " ");
            }

            i1++; i2--; j1++; j2--;
        }
    }
}


