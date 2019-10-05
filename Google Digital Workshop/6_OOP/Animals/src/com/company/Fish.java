package com.company;

public class Fish extends Animal{
    Fish() {
        super(0);
        System.out.println("Fish don't have legs!");
    }
    void walk() {
        System.out.println("Fish cannot walk!!");
    }
    void eat() {
        System.out.println("The fish is eating.");
    }
}
