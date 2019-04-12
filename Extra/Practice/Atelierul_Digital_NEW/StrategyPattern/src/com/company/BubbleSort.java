package com.company;

public class BubbleSort implements SortingStrategy {

    private BubbleSort() {

    }

    private static class SingleTonHelper {
        private static final BubbleSort INSTANCE = new BubbleSort();
    }

    public static BubbleSort getInstance() {
        return SingleTonHelper.INSTANCE;
    }

    @Override
    public void sort(Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i].compareTo(list[j]) > 0) {
                    int x = list[i];
                    list[i] = list[j];
                    list[j] = x;
                }
            }
        }
    }
}
