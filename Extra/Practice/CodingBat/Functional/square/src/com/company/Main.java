package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> square(List<Integer> nums) {
        return nums.parallelStream()
                   .map(i -> i * i)
                   .collect(Collectors.toList());
    }


    public static void main(String[] args) {
	// write your code here
    }
}
