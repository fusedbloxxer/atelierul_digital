package com.company;

class Cat extends Animal implements Pet {
    String name;
    Cat(String name) {
        super(4);
        this.name = name;
        System.out.println("Cats have 4 legs.");
    }
    Cat() {
        this("");
    }
    void eat() {
        System.out.println("The cat is eating.");
    }
    public void setName(String name) {
        this.name = name;
    }
    public void play() {
        System.out.println("The cat is playing.");
    }
    public String getName() {
        if(name == null) {
            throw new NullPointerException("The cat doesn't have a name.");
        }

        return this.name;
    }
}
