package com.company;

import java.util.Map;

public class Main {

    public Map<String, String> topping2(Map<String, String> map) {
        if(map.containsKey("ice cream") && map.get("ice cream").length() > 0) {
            map.put("yogurt", map.get("ice cream"));
        }
        if(map.containsKey("spinach") && map.get("spinach").length() > 0) {
            map.put("spinach", "nuts");
        }

        return map;
    }

    public static void main(String[] args) {

    }
}
