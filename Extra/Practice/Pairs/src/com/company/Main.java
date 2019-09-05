package com.company;

public class Main {

    public static void main(String[] args) throws SizesDoNotMatchException, ColorsDoNotMatchException {
        Running runningShoe1 = new Running("RED", 41);
        Running bootShoe = new Running("BLACK", 45);
        Pair<Running> pairKO = new Pair<>(runningShoe1, bootShoe);
    }
}

class SizesDoNotMatchException extends Exception {

}

class ColorsDoNotMatchException extends Exception {

}

class Pair<T extends Shoe> {
    private T first;
    private T second;

    public Pair(T first, T second) throws SizesDoNotMatchException, ColorsDoNotMatchException {
        if (!first.color.equals(second.color)) {
            throw new SizesDoNotMatchException();
        } else if (first.size != second.size) {
            throw new ColorsDoNotMatchException();
        } else {
            this.first = first;
            this.second = second;
        }
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

abstract class Shoe {
    String color;
    int size;

    Shoe(String color, int size) {
        this.color = color;
        this.size = size;
    }
}

class Running extends Shoe {
    Running(String color, int size) {
        super(color, size);
    }
}

class Heels extends Shoe {
    Heels(String color, int size) {
        super(color, size);
    }
}

class Boot extends Shoe {
    Boot(String color, int size) {
        super(color, size);
    }
}