package com.company.ceva2;

import com.company.ceva1.ceva;

public class something extends ceva {
    public void method() {
        ceva c = new something();
        ((something) c).a = 3;
    }
}
