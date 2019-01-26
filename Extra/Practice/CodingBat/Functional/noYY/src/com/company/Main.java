package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<String> noYY(List<String> strings) {
        return strings
                .parallelStream()
                .filter(s ->  s.length() == 0 || !(s.lastIndexOf("y") == s.length() - 1) && !s.contains("yy"))
                .map(s -> s.concat("y"))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
	// write your code here
    }
}
