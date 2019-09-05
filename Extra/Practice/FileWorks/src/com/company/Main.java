package com.company;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Character, Map<String, Integer>> wordMap = new TreeMap<>();

        Files
                .lines(Path.of("story.txt"))
                .flatMap(line -> Stream.of(line.split("[ .,]")))
                .filter(s -> s.length() > 0)
                .map(String::toLowerCase)
                .forEach(word -> {
                    Map<String, Integer> letter;
                    if (wordMap.containsKey(word.charAt(0))) {
                        letter = wordMap.get(word.charAt(0));

                    } else {
                        wordMap.put(word.charAt(0), letter = new TreeMap<>());

                    }
                    if (letter.containsKey(word)) {
                        letter.put(word, letter.get(word) + 1);

                    } else {
                        letter.put(word, 1);

                    }
                });

        int n = 3, array[];
        array = new int[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        for (int i = 0; i < n; i++) {
            out.printf("%d ", array[i]);
        }

        out.println();

        IntStream.range(1, 4).forEach(elem -> out.printf("%d ", elem));

        // wordMap.entrySet().forEach(System.out::println);
    }
}