package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for(String string: strings) {
            map.put(string, 0);
        }

        return map;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
