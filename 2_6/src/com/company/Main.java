package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        try(Scanner s=new Scanner(new BufferedReader(new FileReader("file.txt"))))
        {
            String[] WordList=new String[1000];
            int[] apparitions=new int[1000];
            int Length=0;

            while(s.hasNextLine())
            {
                String[] aux=s.nextLine().split(" |\\,|\\.|\\!|\\?|\\'");

                for(String currentString: aux)

                    if(currentString.length()>1)
                    {
                        boolean ok=false;
                        for(int index=0;index<Length;index++)
                            if((WordList[index]).equals(currentString))
                            {
                                WordList[index]=currentString;
                                apparitions[index]++;
                                index=WordList.length;
                                ok=true;
                            }

                        if(ok==false) {
                            WordList[Length] = currentString;
                            apparitions[Length]++;
                            Length++;
                        }
                    }
            }

            boolean ok;
            do {ok=false;
                for(int index=0;index<WordList.length-1;index++)
                    if(apparitions[index]<apparitions[index+1])
                    {
                        ok=true;
                        Integer x=apparitions[index];apparitions[index]=apparitions[index+1];apparitions[index+1]=x;
                        String s1=WordList[index];WordList[index]=WordList[index+1];WordList[index+1]=s1;
                    }
            }while(ok==true);

            System.out.println("Top 10(or more if they have the same number of apparitions):");

            for(int index=0;index<Length;index++)
            {
                if(index<10 | (index>9 && apparitions[index]==apparitions[index-1]))
                    System.out.println(WordList[index]+" : "+apparitions[index]);
                else index=Length;
            }
        }
        catch (IOException ex)
        {
            System.out.println("File is not available!");
        }

    }
}