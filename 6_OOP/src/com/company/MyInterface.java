package com.company;

public interface MyInterface {
    void m();
    void m2();
    default void m3() {
        System.out.println("m2");
    }
}
