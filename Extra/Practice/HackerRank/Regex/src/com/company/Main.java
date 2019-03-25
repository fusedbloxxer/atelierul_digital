package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
        }
        */
        scanner.close();

        String string = "riya riya@gmail.com\n" +
                "julia julia@julia.me\n" +
                "julia sjulia@gmail.com\n" +
                "julia julia@gmail.com\n" +
                "samantha samantha@gmail.com\n" +
                "tanya tanya@gmail.com";
        String regEx  = "@gmail.com";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);

        Queue<String> queue = new PriorityQueue<>();

        while(matcher.find()) {
            System.out.println(matcher.group());
            queue.add()
        }
        queue.
    }
}
