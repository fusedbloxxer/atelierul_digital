package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static void GenerateRandomList(String FileName, int Size)throws IOException
    {
        BufferedWriter F=new BufferedWriter(new FileWriter(FileName));

        Random rnd=new Random();
        for(int index=0;index<Size;index++)
        {
            F.write(rnd.nextInt(101) + " ");
        }

        F.close();
    }

    public static void main(String[] args) {

        //Generate Test File
        try{

            GenerateRandomList("date.in", 200);

        }catch (IOException ex)
        {
            System.err.println("Cause: " + ex.getCause() + " Message: " + ex.getMessage());
        }

        //Initialize list
        ArrayList<Integer> myList = new ArrayList<Integer>();
        
        try(Scanner s=new Scanner(new BufferedReader(new FileReader("date.in"))))
        {
            while(s.hasNextInt())
            {
                myList.add(s.nextInt());
            }
            int MaxValue = myList.get(myList.size() - 1);
            System.out.println("The Leaders Are:\n" + MaxValue);
            //O(N) Time Complexity
            //Iterate through the List from right to left
            for(int index = myList.size() - 2; index >= 0; index--){
                //If the current element is bigger than the maximum value then it is a Leader.
                if(myList.get(index) > MaxValue) {
                    System.out.println(myList.get(index));   
                    // Check if there is a bigger number
                    MaxValue = myList.get(index);
                }
            }
        }
        catch (Exception ex)
        {
            System.err.println("File not found! Message: " + ex.getMessage() +" Cause: " + ex.getCause());
        }

    }
}
