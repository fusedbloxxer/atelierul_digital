package com.company;

import java.util.*;

public class Main {

    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for(String string: strings) {
            if(map.containsKey(string.charAt(0) + "")) {
                map.put(string.charAt(0) + "", map.get(string.charAt(0) + "").concat(string));
            } else {
                map.put(string.charAt(0) + "", string);
            }
        }
        return map;
    }

    public static String wordAppend(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(String string: strings) {
            if(map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
                if(map.get(string) % 2 == 1) {
                    stringBuilder.append(string);
                }
            } else {
                map.put(string, 0);
            }
        }
        return stringBuilder.toString();
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for(String string: strings) {
            if(map.containsKey(string)) {
                map.put(string, true);
            } else {
                map.put(string, false);
            }
        }
        return map;
    }

    public static String[] allSwap(String[] strings) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            char firstChar = strings[i].charAt(0);
            if(map.containsKey(firstChar)) {
                Integer index = map.get(firstChar);
                if(index >= 0) {
                    String aux = strings[index];
                    strings[index] = strings[i];
                    strings[i] = aux;

                    map.put(firstChar, -1);
                }
            } else {
                map.put(firstChar, i);
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(allSwap(new String[]{"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"}));
        stringList.stream()
                  .forEach(System.out::println);
    }
}
