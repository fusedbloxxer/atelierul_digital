package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int a[] = TestDataUniqueValues.get_array();
	    for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n" + TestDataUniqueValues.get_expected_result());
    }

    static class TestDataUniqueValues {
        static int arr[];

        public static int[] get_array() {
            Random random = new Random();
            Set<Integer> integerSet = new HashSet<>();
            int length = random.nextInt(1000);

            while(integerSet.size() < length) {
                integerSet.add(random.nextInt(1000));
            }

            int array[] = new int[integerSet.size()];
            int i = 0;

            for(Integer integer: integerSet) {
                array[i++] = integer;
            }

            arr = array;
            return array;
        }

        public static int get_expected_result() {
            int min = arr[0], index = 0;
            for (int i = 1; i < arr.length; i++) {
                if(min > arr[i]) {
                    index = i;
                    min = arr[i];
                }
            }
            return index;
        }

        static class TestDataEmptyArray {
            public static int[] get_array() throws IllegalArgumentException {
                throw new IllegalArgumentException("Exception wasn't thrown as expected");
            }
        }

        static class TestDataExactlyTwoDifferentMinimums {
            static int arr[];
            public static int[] get_array() {
                arr = TestDataUniqueValues.get_array();
                int index = TestDataUniqueValues.get_expected_result();
                Random rnd = new Random();
                int index2 = rnd.nextInt(arr.length - 1);

                arr[index2] = arr[index];
                TestDataUniqueValues.arr[index2] = arr[index];

                return arr;
            }

            public static int get_expected_result() {
                int min = arr[0], index = 0;
                for (int i = 1; i < arr.length; i++) {
                    if(min > arr[i]) {
                        index = i;
                        min = arr[i];
                    }
                }
                return index;
            }
        }
    }


}
