package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> topping3(Map<String, String> map) {
        if(map.containsKey("potato") && map.get("potato").length() > 0) {
            map.put("fries", map.get("potato"));
        }
        if(map.containsKey("salad") && map.get("salad").length() > 0) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
