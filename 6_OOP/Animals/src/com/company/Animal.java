package com.company;

abstract class Animal {
    protected Integer legs;
    protected Animal(int legs) {
        this.legs = legs;
    }
    abstract void eat();
    void walk() {
        System.out.println("This animal walks with " + legs);
    }
}
