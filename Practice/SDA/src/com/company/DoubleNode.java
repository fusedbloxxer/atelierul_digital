package com.company;

public interface DoubleNode<T> extends Node<T> {
    void setPrev(DoubleNode<T> prev);
    DoubleNode<T> getPrev();
}
