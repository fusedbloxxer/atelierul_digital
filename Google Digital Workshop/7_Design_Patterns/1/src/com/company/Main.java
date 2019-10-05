package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setName("John")
                .build();
        person.walk();
        person.drink();
    }
}
class PersonInvocationHandler implements InvocationHandler{
    private IPerson person;
    public PersonInvocationHandler(IPerson person) { this.person = person; }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Instant start = Instant.now();
        Object result = method.invoke(person, args);
        Instant stop = Instant.now();

        // Check annotation type then log in the duration
        System.out.println(Duration.between(start, stop));
        return null;
    }
}
interface IPerson {
    void walk();
    @LogExecutionTime
    void drink();
    String getName();
}
class Person implements IPerson {
    private String name;
    private Person(Builder builder) {
        this.name = builder.name;
    }
    static class Builder {
        String name;
        Builder() {}
        Builder setName(String name) {
            this.name = name;
            return this;
        }
        Person build() {
            return new Person(this);
            /*java.lang.reflect.Proxy.newProxyInstance(
                    PersonInvocationHandler.class.getClassLoader()
                    , new Class[]{IPerson.class}, new PersonInvocationHandler(person));
            */
        }
    }
    @Override
    public void walk() {
        System.out.println(name + " is walking!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void drink() {
        System.out.println(name + " is drinking!");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public String getName() {
        return this.name;
    }
}