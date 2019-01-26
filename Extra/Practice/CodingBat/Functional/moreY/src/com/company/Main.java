package com.company;

import java.util.List;

public class Main {

    public List<String> moreY(List<String> strings) {
        strings
                .replaceAll(element -> {
                    return "y" + element + "y";
                });
        return strings;
    }

    public static void main(String[] args) {

    }
}
