package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("Andrei", "are", "o", "zi", "frumoasa"));
        List<String> words = new ArrayList<>(Arrays.asList("Ask", "Me", "Anything"));

        strings = strings
                .stream()
                .filter(s -> s.length() % 2 == 0)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        abbreviate(strings);
        abbreviate(words);

        Map<String, Integer> map = new TreeMap<>();
        map.put("Andrei", 55);
        map.put("Miah", 44);
        map.put("Noa", 33);
        map.put("Joe", 22);

        String result = map
                .entrySet()
                .stream()
                .map(pair -> pair.getKey() + " " + pair.getValue() + " ")
                .collect(Collectors.joining());

        System.out.println(result);

        new Thread(() -> IntStream
                .range(0, 100)
                .boxed()
                .collect(Collectors.toList())
                .forEach(System.out::println))
                .start();
    }

    private static void abbreviate(List<String> strings) {
        System.out.println(strings
                .stream()
                .map(e -> e.charAt(0) + "")
                .collect(Collectors.joining()));
    }
}
