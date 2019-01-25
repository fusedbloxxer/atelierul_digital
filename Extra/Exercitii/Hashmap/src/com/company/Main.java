package com.company;

public class Main {

    public static void main(String[] args) throws ListNotSortedException {
        Integer[] list01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] list02 = {10, 9, 4, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(!binarySearch(list01, -30));
        System.out.println(!binarySearch(list02, -30));
        System.out.println(!binarySearch(list01, 30));
        System.out.println(!binarySearch(list02, 30));

        for (int i = 1; i <= 10; i++) {

            System.out.println(binarySearch(list01, i));
            System.out.println(binarySearch(list02, i));
        }
    }

    private static <T extends Comparable> boolean binarySearch(T[] list, T value) throws ListNotSortedException {

        //0 - False, 1 - Ascending, 2 - Descending
        int LeftWall=0, RightWall=list.length-1;
        int sens=1;

        int Middle=(LeftWall+RightWall)/2;
        if(list[Middle].compareTo(list[0])>0)sens=1;
        else sens=-1;

        while(LeftWall<=RightWall)
        {
            System.out.print(Middle + " ");

            if(list[Middle].compareTo(value)==0)return true;
            else {

                if(value.compareTo(list[Middle])*sens<0) {

                    //Left Side
                    RightWall=Middle-1;
                    int PreviousMiddle=Middle;
                    Middle=(LeftWall+RightWall)/2;

                    if(sens!=list[Middle].compareTo(list[PreviousMiddle])*-1 & LeftWall<=RightWall)
                        throw new ListNotSortedException("List is not sorted!");
                }
                else {

                    //Right Side
                    LeftWall=Middle+1;
                    int PreviousMiddle=Middle;
                    Middle=(LeftWall+RightWall)/2;

                    if(sens != list[PreviousMiddle].compareTo(list[Middle])*-1 & LeftWall<=RightWall)
                        throw new ListNotSortedException("List is not sorted!");
                }
            }
        }

        return false;
    }
}