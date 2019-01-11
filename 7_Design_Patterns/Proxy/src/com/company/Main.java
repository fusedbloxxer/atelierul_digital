package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GarsonieraInCentru proprietarGarsoniera = new GarsonieraInCentru();
	    ProxyAgentImobiliar proxy = new ProxyAgentImobiliar(proprietarGarsoniera);

	    proprietarGarsoniera.inchiriaza(2_2000);
	    // proxy.inchiriezCuiVreauEu(2_200, "Popescu");
        List strings = new ArrayList();
        strings.add("s1");
        strings.add("s2");
        strings.add(LocalDate.now());

        List<String> proxyStrings = Collections.checkedList(strings, String.class);
        // proxyStrings.add(LocalDate.now());
        proxyStrings.add("s3");
        }
}
class ProxyAgentImobiliar {
    private Garsoniera garsoniera;
    public ProxyAgentImobiliar(Garsoniera garsoniera) {
        this.garsoniera = garsoniera;
    }
    public void inchiriezCuiVreauEu(int suma, String nume) {
        if(nume.startsWith("P")) {
            throw new RuntimeException("Nu lucrez cu P...");
        } else garsoniera.inchiriaza(suma);
    }
}
interface Garsoniera {
    void inchiriaza(int suma);
}
class GarsonieraInCentru implements Garsoniera {
    @Override
    public void inchiriaza(int suma) {
        if(suma < 2_000) {
            throw new RuntimeException("Pleaca, n-ai bani!!");
        } else {
            // OK
        }
    }
}