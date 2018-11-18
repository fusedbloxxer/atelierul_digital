package com.company;

public class Main{

    public static void main(String[] args)
    {
        //3-fizz, 5-buzz, 7-foo, 11-bar

        int n=100;
        for(int i=1;i<=n;i++)
        {
            boolean check=false;
            if(i%3==0){if(i>1)System.out.print(", ");check=true;System.out.print("Fizz");}
            if(i%5==0){if(i>1)System.out.print(", ");check=true;System.out.print("Buzz");}
            if(i%7==0){if(i>1)System.out.print(", ");check=true;System.out.print("Foo");}
            if(i%11==0){if(i>1)System.out.print(", ");check=true;System.out.print("Bar");}

            if(check==false){if(i>1)System.out.print(", ");System.out.print(i);}
        }
    }
}
