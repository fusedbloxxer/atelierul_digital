package com.company;
/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author Speakjava (Simon Ritter)
 */
class Lesson2 {
    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException
     */
    public void runExercises() throws IOException {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 5 solution...");
        exercise5();
        System.out.println("Running exercise 6 solution...");
        exercise6();
        System.out.println("Running exercise 7 solution...");
        exercise7();
    }

    /**
     * Exercise 1
     *
     * Create a new list with all the strings from original list converted to
     * lower case and print them out.
     */
    private void exercise1() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        list.stream()
                .map(String::toLowerCase)
                .collect(toList())
                .forEach(System.out::println);
    }

    /**
     * Exercise 2
     *
     * Modify exercise 1 so that the new list only contains strings that have an
     * odd length
     */
    private void exercise2() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        list.stream()
                .filter(element -> element.length() %2 == 1)
                .map(String::toLowerCase)
                .collect(toList())
                .forEach(System.out::println);
    }

    /**
     * Exercise 3
     *
     * Join the second, third and forth strings of the list into a single string,
     * where each word is separated by a hyphen (-). Print the resulting string.
     */
    private void exercise3() {
        List<String> list = Arrays.asList(
                "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        StringBuilder stringBuilder = new StringBuilder();
        list.stream()
                .forEach(element ->
                    {
                        int index = list.indexOf(element);
                        if(index >= 2 && index <= 4)
                            stringBuilder.append(element + "-");
                    });
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

    /**
     * Count the number of lines in the file using the BufferedReader provided
     */
    private void exercise4() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
                System.out.println(reader.lines().count());
        }
    }

    /**
     * Using the BufferedReader to access the file, create a list of words with
     * no duplicates contained in the file.  Print the words.
     *
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     */
    private void exercise5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {

                List<String> stringSet = reader.lines()
                                          .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                                          .distinct()
                                          .collect(Collectors.toList());
                stringSet.forEach(System.out::println);
        }
    }

    /**
     * Using the BufferedReader to access the file create a list of words from
     * the file, converted to lower-case and with duplicates removed, which is
     * sorted by natural order.  Print the contents of the list.
     */
    private void exercise6() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {

                List<String> stringList = reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .distinct()
                    .map(String::toLowerCase)
                    .sorted()
                    .collect(toList());
                 stringList.forEach(System.out::println);
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    private void exercise7() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
                List<String> stringList = reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .distinct()
                    .map(String::toLowerCase)
                    .sorted(Comparator.comparingInt(String::length))
                    .collect(toList());
                stringList.forEach(System.out::println);
        }
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     * @throws IOException If file access does not work
     */
}
public class Main{
    public static void main(String[] args) throws IOException {
        Lesson2 lesson = new Lesson2();
        lesson.runExercises();
    }
}
