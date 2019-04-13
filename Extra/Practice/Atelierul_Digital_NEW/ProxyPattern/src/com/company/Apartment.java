package com.company;

public class Apartment {
    String location;
    int monthlyRentCost;

    Apartment(String location, int monthlyRentCost) {
        this.location = location;
        this.monthlyRentCost = monthlyRentCost;
    }

    @Override
    public String toString() {
        return
                String.format("Apartment{location='%s', money=%d}", location, monthlyRentCost);
    }
}
