package com.company;

public class SimpleNode <T> implements Node<T> {
    private T value;
    private Node<T> next;

    public SimpleNode(T value) {
        this.value = value;
        this.next = null;
    }

    public SimpleNode(T value, SimpleNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SimpleNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
