package com.company;

public class Main {

    public static void main(String[] args) {
	    Fish d = new Fish();
	    Cat c = new Cat("Fluffy");
	    Animal a = new Fish();
	    Animal e = new Spider();
	    Pet p = new Cat();

	    d.eat();
	    d.walk();

	    c.walk();
	    c.eat();
	    c.play();
		System.out.println("This cat's name is " + c.getName());

	    a.eat();
	    a.walk();

	    e.eat();
	    e.walk();

		System.out.println(p.getName());
		p.setName("Miru");
		System.out.println(p.getName());
		((Cat) p).walk();
    }
}
