package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort implements SortingStrategy {
    Integer[] list;

    private MergeSort() {

    }

    private static class SingleTonHelper {
        private static final MergeSort INSTANCE = new MergeSort();
    }

    public static MergeSort getInstance() {
        return SingleTonHelper.INSTANCE;
    }

    @Override
    public void sort(Integer[] list) {
        this.list = list;
        merge(0, list.length - 1);
    }

    private void printArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void mergeHelper(int start, int middle, int end) {
        Integer[] firstList = Arrays.copyOfRange(list, start, middle + 1);
        Integer[] secondList = Arrays.copyOfRange(list, middle + 1, end + 1);

        int i = 0, j = 0, k = start;

        while (i < firstList.length && j < secondList.length) {
            if (firstList[i].compareTo(secondList[j]) < 0) {
                list[k] = firstList[i];
                i++;
                k++;
            } else {
                list[k] = secondList[j];
                j++;
                k++;
            }
        }

        while (i < firstList.length) {
            list[k] = firstList[i];
            i++;
            k++;
        }

        while (j < secondList.length) {
            list[k] = secondList[j];
            j++;
            k++;
        }
    }

    private void merge(int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;

            merge(start, middle);
            merge(middle + 1, end);
            mergeHelper(start, middle, end);
        }
    }
}
