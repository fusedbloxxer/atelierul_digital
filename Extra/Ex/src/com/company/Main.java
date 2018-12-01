package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List myList = new ArrayList();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");

        List chkList = Collections.checkedList(myList, String.class);
        System.out.println("Checked list content: " + chkList);

        myList.add(10);
        chkList.add(10);

    }
}
