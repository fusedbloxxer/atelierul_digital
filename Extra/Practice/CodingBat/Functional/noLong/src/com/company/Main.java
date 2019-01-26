package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<String> noLong(List<String> strings) {
        return strings
                .parallelStream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
	// write your code here
    }
}
