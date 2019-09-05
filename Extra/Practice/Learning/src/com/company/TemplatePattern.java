package com.company;

import java.util.Arrays;

public class TemplatePattern {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copy01OfArr = Arrays.copyOf(arr, arr.length);
        Integer[] copy02OfArr = Arrays.copyOf(arr, arr.length);

        TemplateMethodBubbleSort asc = new AscBubbleSort();
        asc.sort(copy01OfArr);
        DescBubbleSort des = new DescBubbleSort();
        des.sort(copy02OfArr);

        StrategyPattern.displayArray(copy01OfArr);
        StrategyPattern.displayArray(copy02OfArr);
    }
}

abstract class TemplateMethodBubbleSort {
    void sort(Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (!numbersInCorrectOrder(list[i], list[j])) {
                    int aux = list[i];
                    list[i] = list[j];
                    list[j] = aux;
                }
            }
        }
    }

    abstract boolean numbersInCorrectOrder(Integer i1, Integer i2);
}

class AscBubbleSort extends TemplateMethodBubbleSort {

    @Override
    boolean numbersInCorrectOrder(Integer i1, Integer i2) {
        return i1 < i2;
    }
}

class DescBubbleSort extends TemplateMethodBubbleSort {

    @Override
    boolean numbersInCorrectOrder(Integer i1, Integer i2) {
        return i1 > i2;
    }
}