package com.company;

public class Node2 extends Node<java.lang.Integer> {

    //after type erasure, the method signatures do not match
    void setData(java.lang.Integer data) {
        super.setData(data);
    }
}
