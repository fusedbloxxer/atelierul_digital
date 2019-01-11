package com.company;

public class Student3Builder {
    private String nume;
    private String prenume;
    private String universitate;
    private String dataNastere;

    public Student3Builder setNume(String nume) {
        this.nume = nume;
        return this;
    }

    public Student3Builder setPrenume(String prenume) {
        this.prenume = prenume;
        return this;
    }

    public Student3Builder setUniversitate(String universitate) {
        this.universitate = universitate;
        return this;
    }

    public Student3Builder setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
        return this;
    }

    public Student3 createStudent3() {
        return new Student3(nume, prenume, universitate, dataNastere);
    }
}