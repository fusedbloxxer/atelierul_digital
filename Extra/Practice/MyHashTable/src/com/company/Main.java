package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }
}

interface MyHashTable<K, V> {
    V get(K key);
    void put(K key, V value);
    void remove(K key);
    boolean containsKey(K key);
    int size();
}

class HashTable <K, V> implements MyHashTable<K, V> {
    List<Pair<K, V>> list;

    HashTable() {
        list = new ArrayList<>();
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }
}