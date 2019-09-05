package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        IMyArrayList<Pair<String, Integer>> arrayList = new MyArrayList<>();
        arrayList.add(new Pair<>("Roblox", 244));
        arrayList.add(new Pair<>("Roblox", 244));
        arrayList.add(new Pair<>("Roblox", 244));
        arrayList.add(new Pair<>("Roblox", 244));

        arrayList.set(0, new Pair<>("Danemarca", 335));
        arrayList.remove(new Pair<>("Danemarca", 244));

        arrayList.get(0).sayHi();

        System.out.println(arrayList);
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void sayHi() {
        System.out.println("Hello " + value + " !");
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return key + " : " + value;
    }

    @Override
    public boolean equals(Object obj) {
        Pair<K, V> pair = (Pair<K, V>) obj;
        if (key.equals(pair.getKey())) {
            return true;
        }
        return false;
    }
}

interface IMyArrayList<T> {
    void add(T e);

    void remove(T e);

    T get(int index);

    void set(int index, T e);

    int size();
}

class MyArrayList<T> implements IMyArrayList<T> {
    T[] array;

    MyArrayList() {
        array = (T[]) Array.newInstance(Object.class, 0);
    }

    @Override
    public void add(T e) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = e;
    }

    @Override
    public void remove(T e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(e)) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array = Arrays.copyOf(array, array.length - 1);
                i--;
            }
        }
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, T e) {
        array[index] = e;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append("[" + array[i] + "]");
            if (i < array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.append("]").toString();
    }
}
