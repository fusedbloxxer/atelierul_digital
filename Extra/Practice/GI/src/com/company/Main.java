package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3};
        IArrayIterator<Integer> it = new ArrayIterator<>(arr);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        IGenericList<Integer> list = new GenericList<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            list.insert(arr[i]);
        }
    }
}

interface IArrayIterator<T> {
    boolean hasNext();
    T next();
}

class ArrayIterator <T> implements IArrayIterator<T> {
    T[] elements;
    int index;

    ArrayIterator(T[] elements) {
        this.elements = elements;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < elements.length;
    }

    @Override
    public T next() {
        return elements[index++];
    }
}