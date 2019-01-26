package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> math1(List<Integer> nums) {
        return nums
                .stream()
                .map(i -> (i + 1) * 10)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }
}
