package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int birthday(List<Integer> s, int d, int m) {
        int sum, count = 0;
        for(int i = 0; i < s.size(); i++) {
            sum = 0;
            for(int j = i; j < i + d && j < s.size(); j++) {
                System.out.print(s.get(j) +" ");
                sum += s.get(j);
                if(sum == d && j - i + 1 == m) {
                   count++;
                   break;
                } else if(sum > d) {
                    break;
                }
            }
            System.out.println();
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("test.txt")));
        int N = s.nextInt();
        int d, m;
        List<Integer> mylist = new ArrayList<>();
        while(N-- != 0) {
            mylist.add(s.nextInt());
        }
        d = s.nextInt();
        m = s.nextInt();

        System.out.println(birthday(mylist, d, m));
    }
}
