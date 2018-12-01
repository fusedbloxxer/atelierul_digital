package com.company;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception  {
        int elements = 100_000;
        int searched = 90_000;

        Map<IPerson, Integer> map01 = new HashMap<>();
        logAdding(map01, PersonWithEqualsAndHash.class, elements);
        logSearching(map01, new PersonWithEqualsAndHash("p"+searched, searched));

        Map<IPerson, Integer> map02 = new HashMap<>();
        logAdding(map02, Person.class, elements);
        logSearching(map02, new Person("p"+searched, searched));
    }
    public static <T extends IPerson> void logAdding(Map set, Class clasz, int size) throws Exception {
        Instant startAdd = Instant.now();
        for (int i = 0; i < size; i++) {
            Constructor c = clasz.getConstructor(String.class, int.class);
            set.put((IPerson) c.newInstance("p" + i, i), i);
        }
        Instant stopAdd = Instant.now(); System.out.println("time to logAdding: " + Duration.between(startAdd, stopAdd));
    }
    public static void logSearching(Map set, IPerson p) {
        Instant startSearch = Instant.now();
        System.out.println("searched value is: "+set.get(p));
        Instant stopSearch = Instant.now(); System.out.println("time to search: " + Duration.between(startSearch, stopSearch));
    }
}
interface IPerson {}
class PersonWithEqualsAndHash implements IPerson {
    private String name; private int age;
    public PersonWithEqualsAndHash(String name, int age) {
        this.name = name; this.age = age;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithEqualsAndHash person = (PersonWithEqualsAndHash) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
class Person implements IPerson {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    private String name; private int age;
    public Person(String name, int age) {
        this.name = name; this.age = age;
    }
}
