package com.company;

public interface EndList <T> extends List<T> {
    void removeLast();
    void addLast();
    T getMax();
}
