package com.company;

import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Begin();

        ArrayList<Integer> list = receiveTestCase();

        for(Method sort: SortMethods.class.getDeclaredMethods()) {
            new Thread(() -> {
                try {
                    if(sort.getParameterCount()  == 3 && !sort.getName().equals("partition") && !sort.getName().equals("innerSort")) {

                        Instant start = Instant.now();
                        sort.invoke(new Object(), new ArrayList<>(list), 0 , list.size() - 1);
                        System.out.println(Duration.between(start, Instant.now()) + " -> " + sort.getName());

                    }
                } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                }
            }).start();
        }
    }
    private static void Begin() {
        Long length; int bound;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Generate: ");

        if(scanner.next().equals("yes")) {
            System.out.println("Length: "); length = scanner.nextLong();
            System.out.println("Bound: "); bound = scanner.nextInt();
            generateTestCases(length, bound);
        }
    }
    /*
    private static <E> void printList(List<E> myList) {

        System.out.println(myList.size());
        for (Object aMyList : myList) {
            System.out.print(aMyList + " ");
        }
        System.out.println();
    }
    */
    private static ArrayList<Integer> receiveTestCase() {
        ArrayList<Integer> myList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("testCases.txt")))) {
            while(scanner.hasNextInt()) {
                myList.add(scanner.nextInt());
            }
        } catch (IOException ex) {
            System.out.println("Message: " + ex.getMessage() + " Cause: " + ex.getCause());
        }
        return myList;
    }
    private static void generateTestCases(Long length, int bound) {
        Random random = new Random();
        try(FileWriter fileWriter = new FileWriter("testCases.txt")) {
            while (length-- != 0) {
                fileWriter.write(Integer.toString(random.nextInt(bound)) + " ");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

