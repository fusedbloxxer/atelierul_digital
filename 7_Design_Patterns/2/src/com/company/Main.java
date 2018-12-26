package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DecorateTree christmasTree = new ChristmasTree();
        DecorateTree decoratedTree = new Garland(new Bulb(new Candy(christmasTree)));

        decoratedTree.display();
        christmasTree.display();
    }
}
interface DecorateTree {
    List<List<String>> getTree();
    void display();
}
class Bulb implements DecorateTree {
    private DecorateTree originalTree;

    Bulb(DecorateTree originalTree) { this.originalTree = originalTree;}
    public List<List<String>> getTree() {
        List<List<String>> decoratedTree = new ArrayList<>(originalTree.getTree());
        int decoratedRow = 7;
        List<String> bulbRow = new ArrayList<>(decoratedTree.get(decoratedRow));

        int left = bulbRow.indexOf("<");
        int right = bulbRow.indexOf(">");
        for(int index = left + 1; index < right; index++)
            bulbRow.set(index, "B");
        decoratedTree.set(decoratedRow, bulbRow);

        return decoratedTree;
    }
    public void display() {
        List<List<String>> tree = getTree();
        for(List<String> line: tree) {
            for(String cell: line) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
class Garland implements DecorateTree {
    private DecorateTree originalTree;

    Garland(DecorateTree originalTree) { this.originalTree = originalTree;}
    public List<List<String>> getTree() {
        List<List<String>> decoratedTree = new ArrayList<>(originalTree.getTree());
        int decoratedRow = 8;
        List<String> garlandRow = new ArrayList<>(decoratedTree.get(decoratedRow));

        int left = garlandRow.indexOf("<");
        int right = garlandRow.indexOf(">");
        for(int index = left + 1; index < right; index++)
            garlandRow.set(index, "G");
        decoratedTree.set(decoratedRow, garlandRow);

        return decoratedTree;
    }
    public void display() {
        List<List<String>> tree = getTree();
        for(List<String> line: tree) {
            for(String cell: line) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
class Candy implements DecorateTree {
    private DecorateTree originalTree;

    Candy(DecorateTree originalTree) { this.originalTree = originalTree;}
    public List<List<String>> getTree() {
        List<List<String>> decoratedTree = new ArrayList<>(originalTree.getTree());
        int decoratedRow = 4;
        List<String> candyRow = new ArrayList<>(decoratedTree.get(decoratedRow));

        int left = candyRow.indexOf("<");
        int right = candyRow.indexOf(">");
        for(int index = left + 1; index < right; index++)
            candyRow.set(index, "C");
        decoratedTree.set(decoratedRow, candyRow);

        return decoratedTree;
    }
    public void display() {
        List<List<String>> tree = getTree();
        for(List<String> line: tree) {
            for(String cell: line) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
class ChristmasTree implements DecorateTree {
    private List<List<String>> tree;
    private int size;
    ChristmasTree() { this.size = 10; this.tree = getTree(); }
    public List<List<String>> getTree() {
        List<List<String>> tree = new ArrayList<>();
        List<String> row;
        for (int i = 0; i < size; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < size * 2; j++) {
                if (j == (size - i)) row.add("<");
                if (j == (size + i)) row.add(">");
                row.add(" ");
            }
            tree.add(Collections.unmodifiableList(row));
        }
        for (int i = 0; i < 3; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < size * 2; j++) {
                if (j == size - 2) row.add("|");
                if (j == size + 2) row.add("|");
                row.add(" ");
            }
            tree.add(Collections.unmodifiableList(row));
        }
        return Collections.unmodifiableList(tree);
    }
    public void display() {
        for (List<String> aTree : tree) {
            for (String anATree : aTree) {
                System.out.print(anATree);
            }
            System.out.println();
        }
    }
}
