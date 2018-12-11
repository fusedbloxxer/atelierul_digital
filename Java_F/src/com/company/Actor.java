package com.company;

public class Actor {
    Premiu[] premii;
    String nume;
    Integer varsta;
    Actor(String nume, Integer varsta, Premiu... premii) {
        this.nume = nume;
        this.varsta = varsta;
        this.premii = premii;
    }
}
