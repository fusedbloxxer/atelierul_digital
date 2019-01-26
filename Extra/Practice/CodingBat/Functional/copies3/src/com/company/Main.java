package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> stringList = StringModifier.readFile("word.txt");
        StringModifier.duplicateLetters(stringList, 3);
        stringList.forEach(System.out::println);
    }
}
class StringModifier {
    private static final StringModifier instance = new StringModifier();
    private StringModifier() {}
    public static StringModifier getInstance() {
        return instance;
    }

    public static List<String> readFile(String fileName) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        List<String> stringList = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split(" ");
            stringList.addAll(Arrays.asList(words));
        }
        return stringList;
    }

    public static List<String> duplicateLetters(List<String> strings, int count) {
        strings.replaceAll(element -> element.concat(element).concat(element));
        return strings;
    }
}
