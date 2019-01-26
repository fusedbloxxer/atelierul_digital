package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> mapShare(Map<String, String> map) {
        if(map.containsKey("a") && !map.get("a").isEmpty()) {
            map.put("b", map.get("a"));
        }
        if(map.containsKey("c")) {
            map.remove("c");
        }
        return map;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
