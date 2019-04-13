package com.company;

public class RealEstateAgentProxy {
    Apartment apartment;

    RealEstateAgentProxy() {
    }

    public void represent(Apartment apartment) {
        this.apartment = apartment;
    }

    Apartment rent(Student student) {
        if (!student.name.startsWith("P")) {
            return apartment;
        } else {
            return null;
        }
    }
}
