package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static int[] generateNumbers(int length, int bound) {
        int[] integers = new int[length];
        Random rnd = new Random();

        for(int i = 0; i < length; i++) {
            integers[i] = rnd.nextInt(bound) * ((rnd.nextInt(2) == 0)?1:-1);
        }

        return integers;
    }
    public static int countPairs(int[] integers) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream
                 .of(integers)
                 .forEach(element -> {
                     if(map.containsKey(element * -1) && map.get(element * -1) == 0) {
                        Counter
                                .getInstance()
                                .increaseCounter();
                        map.put(element * -1, 1);
                     } else {
                         map.put(element, 0);
                     }
                 });
        return Counter.getInstance().getCounter();
    }
    static int binarySearch(int array[], int element, int left, int right) {
        int middle = left + (right - left) / 2;
        if(array[middle] == element) {
            return middle;
        } else if(left < right) {
            if(array[middle] < element) {
                return binarySearch(array, element, middle + 1, right);
            } else if(array[middle] > element) {
                return binarySearch(array, element, left, middle - 1);
            }
        }

        return -1;
    }
    static int countPairsFor(int[] integers) {
        int n = 0;
        int arr[] = new int[integers.length - 1];
        for(int i = 0; i < integers.length - 1; i++) {
            if(binarySearch(arr, integers[i], 0, n - 1) == -1 && binarySearch(integers, integers[i] * -1, i + 1, n - 1) != -1) {
                System.out.println(integers[i] + " ");
                Counter.getInstance().increaseCounter();
            } else {
                arr[n] = integers[i];
                n++;
            }
        }
        return Counter.getInstance().getCounter();
    }
    public static void main(String[] args) {
        int[] array = generateNumbers(10, 10);
        Arrays.sort(array);
        IntStream.of(array)
                 .forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println(countPairs(array));
        Counter.getInstance().resetCounter();
        System.out.println(countPairsFor(array));
    }
}
class Counter {
    private static final Counter INSTANCE = new Counter();
    private int counter;
    private Counter() {
        counter = 0;
    }
    static Counter getInstance() {
        return INSTANCE;
    }
    void increaseCounter() {
        counter++;
    }
    int getCounter() {
        return counter;
    }
    void resetCounter() {
        this.counter = 0;
    }
}
