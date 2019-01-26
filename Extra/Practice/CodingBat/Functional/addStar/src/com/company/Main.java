package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<String> addStar(List<String> strings) {
        return strings.parallelStream()
                      .map(s -> s.concat("*"))
                      .collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }
}
