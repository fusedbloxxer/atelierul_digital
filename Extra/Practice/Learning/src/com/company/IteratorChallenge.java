package com.company;

public class IteratorChallenge {
    public static void main(String... args) {
        int[] arr = new int[] {1, 2, 3};
        ArrayCustomIterator it = new ArrayCustomIterator(arr);

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

interface IntegerIterator {
    boolean hasNext();
    int next();
}

class ArrayCustomIterator implements IntegerIterator {
    int [] array;
    int index;

    ArrayCustomIterator(int []array) {
        this.array = array;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public int next() {
        index++;
        return array[index - 1];
    }
}
