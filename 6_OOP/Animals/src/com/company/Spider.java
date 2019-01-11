package com.company;

class Spider extends Animal {
    Spider(){
        super(8);
        System.out.println("The spider has " + legs);
    }
    void eat() {
        System.out.println("The spider is eating.");
    }
}
