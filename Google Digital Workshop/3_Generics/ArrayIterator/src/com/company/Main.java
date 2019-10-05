package com.company;

public class Main {

    public static void main(String[] args) {

        Sock[] socks = new Sock[10];
        Glove[] gloves = new Glove[10];
        for (int i = 1; i <= 10; i++) {
            socks[i] = new Sock(i, "blue");
            gloves[i] = new Glove(i, "maroon");
        }

        IArrayIterator<Sock> socksIterator = new IArrayIterator<>(socks);
        while (socksIterator.hasNext()) {
            System.out.println(socksIterator.next());
        }

        IArrayIterator<Glove> glovesIterator = new IArrayIterator<>(gloves);
        while (glovesIterator.hasNext()) {
            System.out.println(glovesIterator.next());
        }
    }

    interface IArrayIterator<T> {

        boolean hasNext();
        T next();

        IArrayIterator
    }
}
