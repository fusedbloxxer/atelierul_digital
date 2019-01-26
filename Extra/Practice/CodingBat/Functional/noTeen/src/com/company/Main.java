package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> noTeen(List<Integer> nums) {
        return nums.parallelStream()
                .filter(integer -> (integer < 13 || integer > 19))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
	// write your code here
    }
}
