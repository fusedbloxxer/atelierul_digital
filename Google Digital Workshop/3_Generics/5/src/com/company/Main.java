package com.company;

import java.util.ArrayList;
import java.util.List;

interface ClothingItem {
    int getSize();
    String getColor();
}

public class Main {

    static class Clothing implements ClothingItem
    {
        String Color;
        Integer Size;

        public int getSize()
        {
            return Size;
        }

        public String getColor()
        {
            return Color;
        }
    }

    static class Sock extends Clothing
    {
        private Sock(Integer newSize, String newColor)
        {
            Color=newColor;
            Size=newSize;
        }
    }

    static class Glove extends Clothing
    {
        private Glove(Integer newSize, String newColor)
        {
            Color=newColor;
            Size=newSize;
        }
    }

    static class Pair<T extends Clothing>
    {
        T Left, Right;

        private Pair(T left, T right)
        {
            if(!left.getColor().equals(right.getColor()))throw new java.lang.Error("Colors Don't Match");
            else
            {
                if(left.getSize()!=right.getSize())throw new java.lang.Error("Sizes differ !");
                else {

                    Left=left;Right=right;
                }
            }
        }
    }

    public static void main(String[] args){

        Sock[] socks = new Sock[10];
        Glove[] gloves = new Glove[10];

        for (int i = 0; i <= 9; i++) {
            socks[i] = new Sock(i, "blue");
            gloves[i] = new Glove(i, "maroon");
        }

            ArrayIterator<Sock> socksIterator = new ArrayIterator<>(socks);

            while (socksIterator.hasNext()) {
                System.out.println(socksIterator.next());
            }

            ArrayIterator<Glove> glovesIterator = new ArrayIterator<>(gloves);
            while (glovesIterator.hasNext()) {
                System.out.println(glovesIterator.next());
            }

    }

    static class ArrayIterator<T extends Clothing> implements IArrayIterator{

        List<T> Clothes;
        int Index;

        private ArrayIterator(T[] clothes)
        {
            Clothes=new ArrayList<>();
            Index=0;

            for(int index=0;index<clothes.length;index++) {

                if (index <= clothes.length-2)
                    if(clothes[index].getSize() > clothes[index + 1].getSize()) throw new java.lang.Error("ListNotSortedException");

                Clothes.add(clothes[index]);
            }
        }

        public boolean hasNext()
        {
            if(Index+1<Clothes.size())return true;
            else return false;
        }

        public T next()
        {
            return Clothes.get(++Index);
        }
    }
}

    interface IArrayIterator<T> {
        boolean hasNext();
        T next();
    }

