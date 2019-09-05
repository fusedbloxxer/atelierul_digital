package com.company;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Fighter {
    private String name;
    private float health;
    private float damagePerAttack;

    Fighter(String name, float health, float damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public void attack(Fighter opponent) {
        opponent.health -= damagePerAttack;
    }

    public boolean isAlive() {
        return health > 0;
    }
}

class BoxingMatch {
    Fighter firstFighter, secondFighter;

    BoxingMatch(Fighter firstOpponent, Fighter secondOpponent) {
        firstFighter = firstOpponent;
        secondFighter = secondOpponent;
    }

    void fight() {
        while (firstFighter.isAlive() && secondFighter.isAlive()) {
            firstFighter.attack(secondFighter);
            secondFighter.attack(firstFighter);
        }
    }
}

interface Shape {
    void draw();
}

class Rectangular implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangular Shape");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle Shape");
    }
}

class Window {
    private static final String EXCEPTION_SHAPE = "Shape variable is null.";
    Shape shape;

    Window(Shape shape) {
        if (shape == null) {
            throw new NullPointerException(EXCEPTION_SHAPE);
        }
        this.shape = shape;
    }

    public void setShape(Shape shape) {
        if (shape == null) {
            throw new NullPointerException(EXCEPTION_SHAPE);
        }
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }
}

public class Main {
    static String message = "Hi";
    String wow = ":)";

    interface Strategy {
        void fight();
    }

    public static void main(String[] args) {
        Window window = new Window(new Circle());
        window.draw();

        window.setShape(new Rectangular());
        window.draw();
    }

    static class hello {
        void salute(String wow) {
            System.out.println(message);
            System.out.println(wow);
        }
    }

    private static void startBattle(Strategy strategy) {
        strategy.fight();
    }

    @Deprecated
    static String compute2(int number) {
        boolean isNumber = false;
        String output = compute(number);
        if (output.charAt(0) >= '0' && output.charAt(0)<= '9') {
            isNumber = true;
        }
        StringBuilder stringBuilder = new StringBuilder(compute(number));
        int length = stringBuilder.length();

        while (number != 0) {

            if (isNumber) {
                if (number % 10 == 0) {
                    stringBuilder.setCharAt(length, '*');
                }
                length--;
            } else {
                if (number % 10 == 0) {
                    stringBuilder.insert(length, '*');
                }
                length -= 2;
            }
            number /= 10;
        }

        return stringBuilder.toString();
    }

    static String compute(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        int numberCopy = number;

        while (number % 3 == 0) {
            stringBuilder.append("Foo");
            number /= 3;
        }
        while (number % 5 == 0) {
            stringBuilder.append("Bar");
            number /= 5;
        }
        while (number % 7 == 0) {
            stringBuilder.append("Qix");
            number /= 7;
        }

        number = numberCopy;
        List<Integer> list = new ArrayList<>();
        while (number != 0) {
            list.add(number % 10);
            number /= 10;
        }

        for (int index = list.size() - 1; index >= 0; index--) {
            if (list.get(index) == 3) {
                stringBuilder.append("Foo");
            } else if (list.get(index) == 5) {
                stringBuilder.append("Bar");

            } else if (list.get(index) == 7) {
                stringBuilder.append("Qix");

            }
        }

        if (stringBuilder.length() == 0) {
            return String.valueOf(numberCopy);
        }
        return stringBuilder.toString();
    }

    private static void annotationTest() {
        Book book = new AmazonBook("World of Warcraft");
        Class myClass = book.getClass();

        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(CheckedMethod.class)) {
                System.out.println(method.getAnnotation(CheckedMethod.class).value());
            }
        }
    }

}

@interface EnhancementRequest {
    String id();

    String synopsis();

    String engineer() default "unassigned";

    String date() default "unknown";
}

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface BookSerializable {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface BookElement {
    String title() default "N/A";

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModfiiedBy() default "N/A";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CheckedMethod {
    String value();
    int id();
}

@BookSerializable
class Book {
    @BookElement
    private String title;

    private String author;

    Book(String title) {
        this.title = title;
    }

    void read() {
        System.out.println("Reading ...");
    }
}

class AmazonBook extends Book {

    AmazonBook(String title) {
        super(title);
    }

    @CheckedMethod(value = "Report me = ok", id = 32)
    void read(int ok) {
        System.out.println("Reading intensely ...");
    }
}