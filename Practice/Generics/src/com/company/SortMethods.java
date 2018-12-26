package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortMethods {

    static <E extends Comparable<E>> int partition(List<E> myList, int left, int right) {
        E pivot = myList.get(left + (right - left) / 2);

        while(left <= right) {
            while(myList.get(left).compareTo(pivot) < 0)
                left++;
            while(myList.get(right).compareTo(pivot) > 0)
                right--;
            if(left <= right) {
                Collections.swap(myList, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static <E extends Comparable<E>> void quickSort(List<E> myList, int left, int right) {
        int index = partition(myList, left, right);
        if(left < index - 1)
            quickSort(myList, left, index - 1);
        if(index < right)
            quickSort(myList, index, right);
    }

    static <E extends Comparable<E>> void innerSort(List<E> myList, int left, int middle, int right) {
        int i = 0, j = 0, k = left;
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<E> LeftPart = new ArrayList<>(myList.subList(left, middle + 1));
        List<E> RightPart = new ArrayList<>(myList.subList(middle + 1, right + 1));

        while(i < n1 && j < n2) {
            if(LeftPart.get(i).compareTo(RightPart.get(j)) <= 0) {
                myList.set(k, LeftPart.get(i));
                i++;
            } else {
                myList.set(k, RightPart.get(j));
                j++;
            }
            k++;
        }

        while(i < n1) {
            myList.set(k, LeftPart.get(i));
            k++;
            i++;
        }

        while(j < n2) {
            myList.set(k, RightPart.get(j));
            k++;
            j++;
        }
    }

    static <E extends Comparable<E>> void mergeSort(List<E> myList, int left, int right) {
        if(left == right) {
            return;
        } else if(right - left == 1) {
            if(myList.get(left).compareTo(myList.get(right)) > 0) {
                Collections.swap(myList, left, right);
            }
        } else if(left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(myList, left, middle);
            mergeSort(myList, middle + 1, right);

            innerSort(myList, left, middle, right);
        }
    }

    static <E extends Comparable<E>> void insertionsSort(List<E> myList, int left, int right) {
        for(int index = left + 1; index < right; index++) {
            for(int index2 = index - 1; index2 > left; index2--) {
                if(myList.get(index2).compareTo(myList.get(index2 - 1)) < 0)
                    Collections.swap(myList, index2, index2 - 1);
                else continue;
            }
        }
    }

    static <E extends Comparable<E>> void forSort(List<E> myList, int left, int right) {
        for(int index = left; index < right - 1; index++) {
            for(int index2 = index + 1; index2 < right; index2++) {
                if(myList.get(index).compareTo(myList.get(index2)) > 0) {
                    Collections.swap(myList, index, index2);
                }
            }
        }
    }

    static <E extends Comparable<E>> void bubbleSort(List<E> myList, int left, int right) {
        boolean swapped = false;
        do{
            swapped = false;
            for(int index = left; index < right - 1; index++) {
                if(myList.get(index).compareTo(myList.get(index + 1)) > 0) {
                    Collections.swap(myList, index, index + 1);
                    swapped = true;
                }
            }
        }while(swapped == true);
    }
}
