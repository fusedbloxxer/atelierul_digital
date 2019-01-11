package com.company;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Main {

    static class C1 {
        public void m() {
            System.out.println("m");
        }
    }

    static class C2 {
        private C1 c1;
        public C2(C1 c1) {
            this.c1 = c1;
        }
        public void m2() {
            System.out.println("m2");
        }
    }
    // OCP
    // - imi permite sa adaug clase noi
    // nu imi da voie sa modific metode existente
    // @Delegate, @Builder, @Singleton
    public static void main(String[] args) {
        int a0 = 1;
        int b0 = 2;
        m(a0, b0, (a, b) -> a + b);
        m(a0, b0, (a, b) -> a + b);
    }

    public static Integer m(Integer a, Integer b, BiFunction<Integer, Integer, Integer> operation) {
        return operation.apply(a, b);
    }
}
