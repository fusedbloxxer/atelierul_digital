package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<String> noX(List<String> strings) {

        return
        strings
                .parallelStream()
                .map(s -> s.replaceAll("x", ""))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList( "ax", "bb", "cx");
        noX(stringList)
                .forEach(System.out::println);
    }
}
