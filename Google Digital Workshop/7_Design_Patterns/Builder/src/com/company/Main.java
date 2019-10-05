package com.company;

public class Main {
    public static void main(String[] args) {
        Student3 st03 = new Student3Builder()
                .setNume("ion")
                .createStudent3();
    }
}
//varianta 2 - composition
class Car {
    Engine
    public void startCar() {
        //TODO schimb viteza in treapta 1
        changeGear(1);
        // start engine
        startEngine();
    }
}
interface Engine {

}
interface GearBox {
}
class V8Engine implements Engine {
    public void startEngine() {
        System.out.println("V8 engine started.");
    }
}

//varianta 1 - mostenire
/*class Car extends Engine {
    public void startCar() {
        //TODO schimb viteza in treapta 1
        changeGear(1);
        // start engine
        startEngine();
    }
}
class GearBox {
    private int currentGear = 1;
    public void changeGear(int gear) {
        this.currentGear = gear;
    }
}
class Engine extends GearBox {
    public void startEngine() {
        System.out.println("Engine started.");
    }
}*/
class Student3 {
    // required
    private String nume;
    // optional
    private String prenume;
    private String universitate;
    private String dataNastere;

    public Student3(String nume, String prenume, String universitate, String dataNastere) {
        this.nume = nume;
        this.prenume = prenume;
        this.universitate = universitate;
        this.dataNastere = dataNastere;
    }
}
// class Student2(String nume, String prenume); in the future