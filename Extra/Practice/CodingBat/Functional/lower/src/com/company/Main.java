package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<String> lower(List<String> strings) {
        return strings
                .stream()
                .map(i -> i.toLowerCase())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }
}
