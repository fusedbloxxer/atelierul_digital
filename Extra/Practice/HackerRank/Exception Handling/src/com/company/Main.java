package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer x, y;
        try {
            x = s.nextInt();
            y = s.nextInt();
            System.out.println(x / y);
        } catch (InputMismatchException ex) {
            System.out.print("java.util.InputMismatchException");
        } catch (ArithmeticException ex) {
            System.out.print("java.lang.ArithmeticException: / by zero");
        }
    }
}
