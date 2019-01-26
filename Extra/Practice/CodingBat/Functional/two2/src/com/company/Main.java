package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> two2(List<Integer> nums) {
        return nums
                .parallelStream()
                .map(i -> i * 2)
                .filter(i -> i % 10 != 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
	// write your code here
    }
}
