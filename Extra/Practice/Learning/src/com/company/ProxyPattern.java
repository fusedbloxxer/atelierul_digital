package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ProxyPattern {
    public static void main(String[] args) {
        Apartment app01 = new Apartment("Crangasi01", 300);
        Apartment app02 = new Apartment("Crangasi02", 600);
        Apartment app03 = new Apartment("Crangasi03", 350);
        Apartment app04 = new Apartment("Crangasi04", 400);
        Apartment app05 = new Apartment("Crangasi05", 200);

        RealEstateAgentProxy proxy = new RealEstateAgentProxy();
        proxy.represent(app01);
        proxy.represent(app02);
        proxy.represent(app03);
        proxy.represent(app04);
        proxy.represent(app05);

        Student student01 = new Student("Ionescu", 500);
        Student student02 = new Student("Popescu", 330);

        Apartment apartmentForStudent01 = proxy.rent(student01);
        System.out.println(student01 + " rented " + apartmentForStudent01);
        Apartment apartmentForStudent02 = proxy.rent(student02);
        System.out.println(student02 + " rented " + apartmentForStudent02);
    }
}

class Apartment {
    private String location;
    private int monthlyRentCost;
    private boolean isRented;

    public Apartment(String location, int monthlyRentCost) {
        this.location = location;
        this.monthlyRentCost = monthlyRentCost;
        this.isRented = false;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMonthlyRentCost() {
        return monthlyRentCost;
    }

    public void setMonthlyRentCost(int monthlyRentCost) {
        this.monthlyRentCost = monthlyRentCost;
    }
}

interface ApartmentProxy {
    void represent(Apartment apartment);

    Apartment rent(Student student);
}

class RealEstateAgentProxy implements ApartmentProxy {
    List<Apartment> apartments;

    RealEstateAgentProxy() {
        apartments = new ArrayList<>();
    }

    @Override
    public void represent(Apartment apartment) {
        apartments.add(apartment);
    }

    @Override
    public Apartment rent(Student student) {
        if (student.getName().charAt(0) != 'P') {
            for (Apartment apartment : apartments) {
                if (!apartment.isRented() && apartment.getMonthlyRentCost() <= student.getMoney()) {
                    apartment.setRented(true);
                    return apartment;
                }
            }
        }
        return null;
    }
}

class Student {
    private String name;
    private int money;

    public Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
