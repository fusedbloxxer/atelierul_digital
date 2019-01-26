package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> topping1(Map<String, String> map) {
        if(map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }
        map.put("bread", "butter");
        return map;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
