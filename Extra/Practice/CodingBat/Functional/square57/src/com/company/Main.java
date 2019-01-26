package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> square56(List<Integer> nums) {
        return nums
                .parallelStream()
                .map(i -> i * i + 10)
                .filter(i -> !(i % 10 == 5 || i % 10 == 6))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
	// write your code here
    }
}
