package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> mapBully(Map<String, String> map) {
        if(map.containsKey("a") && !map.get("a").isEmpty()) {
            map.put("b", map.get("a"));
            map.put("a", "");
        }
        return map;
    }


    public static void main(String[] args) {
    }
}
