package com.company;

public class Main {

    public static void main(String[] args) {
	    //B b = new B();
        class Q {}
        Main main = new Main();
        main.m(5);
        MyInterface myInterface = new MyInterface() {
            @Override
            public void m() {
                System.out.println("m");
            }

            @Override
            public void m2() {
                System.out.println("m2");
            }
        };
    }
    int i = 0; // shadows parameter i from m method
    public void m(int i) {
        class Q {
            int i = 2;
        }
        Q q = new Q();
        System.out.println(i + this.i);
    }


   /* class A {
        int i = 1;
        class B {
            int i =2;
            class C {
                int i = 3;
                public static void m() {
                    System.out.println(this.i + B.i + A.i);
                }
            }
        }
    }
*/
}
