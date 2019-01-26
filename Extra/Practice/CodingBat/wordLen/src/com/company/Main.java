package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for(String string : strings) {
            map.put(string, string.length());
        }
        return map;
    }


    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for(String string: strings) {
            map.put(string.charAt(0) + "", string.charAt(string.length() - 1) + "");
        }
        return map;
    }

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for(String string: strings) {
            if(map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
