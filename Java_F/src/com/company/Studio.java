package com.company;

public class Studio {
    String nume;
    Film[] filme;
    Studio(String nume, Film... filme) {
        this.nume = nume;
        this.filme = filme;
    }

}
