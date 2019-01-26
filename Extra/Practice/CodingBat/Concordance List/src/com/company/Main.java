package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        TextModifierSingleton
                .getDictionary(TextModifierSingleton.readWords("words.txt"))
                .forEach((k, v) -> {
                    System.out.println("->" + k + "");
                    v.forEach(word -> System.out.println("   ->" + word));
                });
    }
}
class TextModifierSingleton {
    private static final TextModifierSingleton TEXT_MODIFIER = new TextModifierSingleton();
    private TextModifierSingleton() {}
    public static TextModifierSingleton getInstance() { return TEXT_MODIFIER; }
    public static List<String> readWords(String fileName) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
        List<String> stringList = new ArrayList<>();
        while(s.hasNext()) {
            stringList.add(s.next());
        }
        return stringList;
    }
    public static Map<Character, TreeSet<String>> getDictionary(List<String> strings) {
        Map<Character, TreeSet<String>> map = new TreeMap<>();
        strings
                .parallelStream()
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[.?!-]", ""))
                .distinct()
                .forEach(e -> {
                    if(map.containsKey(e.charAt(0))) {
                        map.get(e.charAt(0)).add(e);
                    } else {
                        map.put(e.charAt(0), new TreeSet<>(Collections.singleton(e)));
                    }
                });
        return map;
    }
}