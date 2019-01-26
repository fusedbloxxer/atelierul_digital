package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> mapAB3(Map<String, String> map) {
        if(map.containsKey("a") && map.containsKey("b")) {
            if(!map.get("a").isEmpty() && map.get("b").isEmpty()) {
                map.put("b", map.get("a"));
            } else {
                    if(map.get("a").isEmpty() && !map.get("b").isEmpty())
                    map.put("a", map.get("b"));
            }
        } else if(map.containsKey("a")) {
            map.put("b", map.get("a"));
        } else if(map.containsKey("b")) {
            map.put("a", map.get("b"));
        }
        return map;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
