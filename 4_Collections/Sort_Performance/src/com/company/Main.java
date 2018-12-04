package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {
    private static <T extends Comparable> void  BubbleSort(List<T> list) {
        Instant start = Instant.now();

        boolean check;
        do{
            check=false;
            for(int index = 0; index < list.size() - 1; index++)
                if(list.get(index).compareTo(list.get(index + 1)) > 0){
                    T AUX = list.get(index);
                    list.set(index, list.get(index + 1));
                    list.set(index + 1, AUX);
                    check = true;
                }

        }while(check);

        Instant stop = Instant.now();
        System.out.println("BubbleSort: " + Duration.between(start, stop));
    }
    private static <T extends Comparable> void  QuickSort(List<T> list, int Left, int Right) {
        if(Left >= Right){
            //return;
        } else {
            T Pivot = list.get((Left + Right) / 2);
            int Index = partition(list, Left, Right, Pivot);
            QuickSort(list, Left, Index - 1);
            QuickSort(list, Right, Index);
        }
    }
    private static <T extends Comparable> int  partition(List<T> list, int Left, int Right, T Pivot) {
        while(Left <= Right){
            while(list.get(Left).compareTo(Pivot) < 0) Left++;
            while(list.get(Right).compareTo(Pivot) > 0) Right--;
            T AUX = list.get(Left);
            list.set(Left++, list.get(Right));
            list.set(Right--, AUX);
        }
        return Left;
    }
    private static void readIntegers(String FileName, List<Integer> myList) {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(FileName)))){
            while (scanner.hasNext()){
                myList.add(scanner.nextInt());
            }
        } catch(IOException ex) {
            System.out.println("An exception occurred! Message: " + ex.getMessage() + " Cause: " + ex.getCause());
        }
    }
    private static void readWords(String FileName, List<String> myList) {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(FileName)))){
            while (scanner.hasNext()){
                myList.add(scanner.next());
            }
        } catch(IOException ex) {
            System.out.println("An exception occurred! Message: " + ex.getMessage() + " Cause: " + ex.getCause());
        }
    }
    private static <T> void PrintElements(List<T> myList) {
        System.out.print(myList.getClass().getSimpleName()+ "<" + myList.get(0).getClass().getSimpleName() + ">: ");
        if(myList.getClass().getSimpleName().equals("ArrayList"))System.out.print(" ");

        Iterator<T> iterator = myList.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int Option;

        try{
            System.out.print("(1) Read Word List.\n(2) Read Integers\nOption: ");
            Option = scanner.nextInt();

            String FileName;

            switch (Option) {
                case 1: {
                    FileName = "array2.txt";

                    ArrayList<String> array = new ArrayList<>();
                    LinkedList<String> list = new LinkedList<>();

                    readWords(FileName, array);
                    readWords(FileName, list);

                    PrintElements(array);
                    PrintElements(list);

                    System.out.print("(1) BubbleSort\n(2) QuickSort\nOption: ");
                    Option = scanner.nextInt();

                    switch (Option){
                        case 1:{
                            BubbleSort(array);
                            PrintElements(array);
                            BubbleSort(list);
                            PrintElements(list);
                        }break;
                        case 2:{

                            Instant start, stop;

                            start = Instant.now();
                            QuickSort(array, 0, array.size() - 1);
                            PrintElements(array);
                            stop = Instant.now();
                            System.out.println("ArrayList sorted: " + Duration.between(stop, start));

                            start = Instant.now();
                            QuickSort(list, 0, array.size() - 1);
                            PrintElements(list);
                            stop = Instant.now();
                            System.out.println("LinkedList sorted: " + Duration.between(stop, start));
                        }break;
                        default: System.out.print("Nothing.");
                    }
                }
                break;
                case 2: {
                    FileName = "array1.txt";

                    ArrayList<Integer> array = new ArrayList<>();
                    LinkedList<Integer> list = new LinkedList<>();

                    readIntegers(FileName, array);
                    readIntegers(FileName, list);

                    PrintElements(array);
                    PrintElements(list);

                    System.out.print("(1) BubbleSort\n(2) QuickSort\nOption: ");
                    Option = scanner.nextInt();

                    switch (Option){
                        case 1:{
                            BubbleSort(array);
                            PrintElements(array);
                            BubbleSort(list);
                            PrintElements(list);
                        }break;
                        case 2:{

                            Instant start, stop;

                            start = Instant.now();
                            QuickSort(array, 0, array.size() - 1);
                            PrintElements(array);
                            stop = Instant.now();
                            System.out.println("ArrayList sorted: " + Duration.between(stop, start));

                            start = Instant.now();
                            QuickSort(list, 0, array.size() - 1);
                            PrintElements(list);
                            stop = Instant.now();
                            System.out.println("LinkedList sorted: " + Duration.between(stop, start));
                        }break;
                        default: System.out.print("Nothing.");
                    }
                }
                break;
            }

        } catch (Exception ex) {
            System.out.print("An error occured!");
        }
    }
}