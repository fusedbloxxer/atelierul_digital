package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> mapAB(Map<String, String> map) {
        if(map.containsKey("a") && map.containsKey("b")) {
            map.put("ab", map.get("a").concat(map.get("b")));
        }
        return map;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
