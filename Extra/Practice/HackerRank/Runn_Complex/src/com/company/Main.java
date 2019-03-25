package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            if(x <= 1) System.out.println("Not prime");
            else {
                boolean check = true;
                for(int j = 2; j <= Math.sqrt(x); j++) {
                    if(x % j == 0) { System.out.println("Not prime"); check = false; break; }
                }
                if(check) System.out.println("Prime");
            }
        }
    }
}