package com.company;

import java.util.Arrays;

public class StrategyPattern {
    public static void main(String... args) {
        Integer[] arr = new Integer[] {1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copy01OfArr = Arrays.copyOf(arr, arr.length);
        Integer[] copy02OfArr = Arrays.copyOf(arr, arr.length);
        Integer[] copy03OfArr = Arrays.copyOf(arr, arr.length);

        displaySorted(BubbleSort.getInstance(), copy01OfArr);
        displaySorted(MergeSort.getInstance(), copy02OfArr);
        displaySorted(Quicksort.getInstance(), copy03OfArr);
    }

    private static void displaySorted(SortingStrategy strategy, Integer[] arr) {
        strategy.sort(arr);
        displayArray(arr);
    }

    static void displayArray(Integer[] arr) {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }

        System.out.println();
    }
}

interface SortingStrategy {
    void sort(Integer[] list);
}

class BubbleSort implements SortingStrategy {
    private static BubbleSort INSTANCE;

    private BubbleSort() {}

    static BubbleSort getInstance() {
        if (INSTANCE == null) {
            synchronized (BubbleSort.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BubbleSort();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void sort(Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    int x = list[i];
                    list[i] = list[j];
                    list[j] = x;
                }
            }
        }
    }
}

class MergeSort implements SortingStrategy {
    private static MergeSort INSTANCE;

    private MergeSort() {}

    static MergeSort getInstance() {
        if (INSTANCE == null) {
            synchronized (MergeSort.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MergeSort();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void sort(Integer[] list) {
        mergeSort(0, list.length - 1, list);
    }

    private void mergeSort(int start, int end, Integer[] list) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(start, middle, list);
            mergeSort(middle + 1, end, list);

            merge(start, middle, end, list);
        }
    }

    private void merge(int start, int middle, int end, Integer[] list) {
        Integer[] arr1 = Arrays.copyOfRange(list, start, middle + 1);
        Integer[] arr2 = Arrays.copyOfRange(list, middle + 1, end + 1);

        int k = start, i = 0, j = 0;

        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                list[k] = arr1[i];
                k++;
                i++;
            } else {
                list[k] = arr2[j];
                k++;
                j++;
            }
        }

        while(i < arr1.length) {
            list[k] = arr1[i];
            k++;
            i++;
        }

        while(j < arr2.length) {
            list[k] = arr2[j];
            k++;
            j++;
        }
    }
}

class Quicksort implements SortingStrategy {
    private Quicksort() {}

    private static class SingletonHelper {
        private static final Quicksort INSTANCE = new Quicksort();
    }

    static Quicksort getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void sort(Integer[] list) {
        quicksort(0, list.length - 1, list);
    }

    private void quicksort(int start, int end, Integer[] list) {
        if (start < end) {
            int pivot = getPivot(start, end, list);
            quicksort(start, pivot - 1, list);
            quicksort(pivot + 1, end, list);
        }
    }

    private int getPivot(int start, int end, Integer[] list) {
        int i = 0, j = -1;

        while (start < end) {
            if (list[start] >= list[end]) {
                int aux = list[start];
                list[start] = list[end];
                list[end] = aux;

                aux = i;
                i = -j;
                j = -aux;
            }

            start += i;
            end += j;
        }

        return start;
    }
}
