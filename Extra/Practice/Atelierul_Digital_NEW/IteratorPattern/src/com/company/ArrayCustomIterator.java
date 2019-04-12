package com.company;

public class ArrayCustomIterator implements IArrayCustomIterator {
    private int[] arr;
    private int index;

    ArrayCustomIterator(int []arr) {
        this.arr = arr;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < arr.length) {
            return true;
        }
        return false;
    }

    @Override
    public int next() {
        if (index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Array is out of bounds.");
        }
        return arr[index++];
    }
}
