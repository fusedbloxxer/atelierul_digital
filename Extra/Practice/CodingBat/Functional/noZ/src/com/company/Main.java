package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<String> noZ(List<String> strings) {
        return strings
                .parallelStream()
                .filter(s -> !s.contains("z"))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
	// write your code here
    }
}
