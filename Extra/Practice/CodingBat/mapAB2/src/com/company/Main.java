package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> mapAB2(Map<String, String> map) {
        if(map.containsKey("a") && map.containsKey("b") && map.get("a").equals(map.get("b"))) {
            map.remove("a");
            map.remove("b");
        }
        return map;
    }


    public static void main(String[] args) {

    }
}
