package com.company;

public class GenericList <T> implements IGenericList<T> {
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
