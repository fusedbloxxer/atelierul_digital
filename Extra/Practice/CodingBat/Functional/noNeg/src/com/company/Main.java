package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> noNeg(List<Integer> nums) {
        return
                nums.parallelStream()
                    .filter(i -> i >= 0)
                    .collect(Collectors.toList());
    }


    public static void main(String[] args) {
	// write your code here
    }
}
