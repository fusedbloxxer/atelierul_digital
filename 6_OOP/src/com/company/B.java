package com.company;

public class B extends A{
    static int i;
    int i2;
    int i3;
    static {//se executa atunci cand se incarca clasa
        i = 0;
        System.out.println("B static int");
    }
    {//se executa la initializare
        i2 = 1;
        System.out.println("B regular int");
    }
    public B() {
        System.out.println("B constructor");
    }
}
