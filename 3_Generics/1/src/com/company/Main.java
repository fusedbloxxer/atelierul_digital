package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<? extends Number> pe = new ArrayList<>();
        List<? super Number> cs = new ArrayList<>();

        //pe.add(new Integer(5));
        cs.add(1);

    }
}
