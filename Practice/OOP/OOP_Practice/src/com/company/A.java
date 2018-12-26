package com.company;

public class A {
    static int i;
    int i2;
    int i3;
    static {    //se executa atunci cand se incarca clasa
        i = 0;
        System.out.println("A static int");
    }
    {   //se executa la initializare
        i2 = 1;
        System.out.println("A regular int");
    }
    public A() {
        System.out.println("A constructor");
    }
}
