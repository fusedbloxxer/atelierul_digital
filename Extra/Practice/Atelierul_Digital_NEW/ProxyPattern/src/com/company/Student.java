package com.company;

public class Student {
    String name;
    int money;

    Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return
                String.format("Student{name='%s', money=%d}", name, money);
    }
}
