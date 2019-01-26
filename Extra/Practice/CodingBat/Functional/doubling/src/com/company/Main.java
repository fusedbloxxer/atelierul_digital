package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static void doubleList(List<Integer> list) {
        list.replaceAll(element -> element * 2);
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            if(scanner.hasNextInt()) {
                int N = scanner.nextInt();
                List<Integer> integerList = new ArrayList<>();
                for(int i = 0; i < N; i++) {
                    integerList.add(i + 1);
                }
                doubleList(integerList);
                integerList.forEach(i -> System.out.print(i + " "));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " cause " + ex.getCause());
        }
    }
}
