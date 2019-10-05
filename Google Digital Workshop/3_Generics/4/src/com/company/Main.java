package com.company;

import javax.management.RuntimeErrorException;

interface ClothingItem {

    int getSize();
    String getColor();

}

public class Main{

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

    public static void main(String[] args) {

        Sock blueSock = new Sock(10, "blue");
        Sock redSock  = new Sock(10, "red");
        Glove yellowGlove = new Glove(15, "yellow");
        Glove bigYellowGlove = new Glove(17, "yellow");

        //Pair socksPair01 = new Pair(blueSock, yellowGlove); //should not be allowed, but is for backwards compatibility
        //Pair<Sock> socksPair02 = new Pair<>(blueSock, yellowGlove); //compile-time error
        //Pair<Sock> socksPair03 = new Pair<>(blueSock, redSock); //should throw run-time error, colors do not match
        //Pair<Glove> glovesPair01 = new Pair<>(yellowGlove, bigYellowGlove); //should throw run-time error, sizes do not match

        Sock left = new Sock(10, "green");
        Sock right  = new Sock(10, "green");

        Pair<Sock> socksPair04 = new Pair<>(left, right); //pars match so no error
        System.out.println("Left Sock(" + socksPair04.Left.getColor() + ", " + socksPair04.Left.getSize() + ") Right Sock(" + socksPair04.Right.getColor() + "," + socksPair04.Right.getSize() + ")");

    }
}
