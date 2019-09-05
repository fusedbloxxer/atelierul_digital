package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String LOCATION = "C:\\Users\\AnonymousClass\\WorkFolder\\GIT\\atelierul_digital\\Extra\\Practice\\SecretMessage\\input.txt";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(LOCATION))) {
            int c;
            while ((c = br.read()) != -1) {
                if (c >= 'A' && c <= 'Z') {
                    if (c == 'X') {
                        System.out.print(" ");
                    } else {
                        System.out.print((char) c);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " : " + ex.getMessage());
        }
    }
}
