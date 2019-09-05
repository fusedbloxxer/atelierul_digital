package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
    public static final String LOCATION = "C:\\Users\\AnonymousClass\\WorkFolder\\GIT\\atelierul_digital\\Extra\\Practice\\HardCodeChallenge\\phonebook.txt";

    public static void main(String[] args) {
        try (Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(LOCATION)))) {
            while (fileScanner.hasNext()) {
                String content = fileScanner.next();
                if (content.equals("Abdul") || content.equals("Abbey")) {
                    System.out.println(fileScanner.next());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " : " + ex.getMessage());
        }
    }
}