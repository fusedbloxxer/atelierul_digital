package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> no9(List<Integer> nums) {
        return nums
                .parallelStream()
                .filter(i -> i % 10 != 9)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
	// write your code here
    }
}
