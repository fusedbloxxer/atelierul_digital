package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String rootValue = "a";
        IGenericList<String> list = new GenericList<>(rootValue);
        for (int i = 1; i < 10; i++) {
            list.insert(String.valueOf(Character.valueOf((char) (rootValue.charAt(0) + i))));
        }

        list.println();
    }
}

interface IGenericNode<T> {
    T getValue();
    void setValue(T value);
    IGenericNode<T> getNext();
    void setNext(IGenericNode<T> next);
}

interface IGenericList<T> {
    void insert(T element);
    void println();
}

class GenericList <T> implements IGenericList<T> {
    IGenericNode<T> head;
    IGenericNode<T> tail;

    GenericList(T value) {
        head = new GenericNode<>(value);
        tail = head;
    }

    @Override
    public void insert(T element) {
        GenericNode<T> node = new GenericNode<>(element);
        tail.setNext(node);
        tail = tail.getNext();
    }

    @Override
    public void println() {
        IGenericNode<T> node = head;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
    }
}

class GenericNode <T> implements IGenericNode<T> {
    private T value;
    private IGenericNode<T> next;

    GenericNode(T value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public IGenericNode<T> getNext() {
        return next;
    }

    @Override
    public void setNext(IGenericNode<T> next) {
        this.next = next;
    }
}
