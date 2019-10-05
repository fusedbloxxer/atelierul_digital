package com.company;

public class Film {
    Integer an_aparitie;
    String nume;
    Actor[] actori;
    Film(Integer an_aparitie, String nume, Actor... actori) {
        this.an_aparitie = an_aparitie;
        this.nume = nume;
        this.actori = actori;
    }
}
