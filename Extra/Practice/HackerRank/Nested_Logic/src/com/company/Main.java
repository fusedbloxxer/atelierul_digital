package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = (new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()))
                .compareTo(new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        System.out.println(result);
    }
}
class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Date expected) {
        if(year < expected.getYear()) return 0;
        else if(year > expected.getYear()) return 10_000;
        else if(month < expected.getMonth()) return 0;
        else if(month > expected.getMonth()) return 500 * (month - expected.getMonth());
        else if(day <= expected.getDay()) return 0;
        else return  15 *(day - expected.getDay());
    }
}