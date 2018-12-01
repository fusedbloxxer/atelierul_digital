package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");breakAList(list);
        //list.add(new Integer(6)); error

        System.out.println(list);
    }

    public static <L extends List<String>> void breakAList(L list) {

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
    }
}
