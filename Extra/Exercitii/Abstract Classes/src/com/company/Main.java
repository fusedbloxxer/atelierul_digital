package com.company;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println((new PerformOperation()).divisor_sum(6));
    }
}
class PerformOperation {
    Integer x;
    boolean isOdd() {
        return IntStream
                .of(x)
                .anyMatch(e -> e % 2 == 1);
    }
    boolean isPrime() {
        if(x <= 1) return false;
        return IntStream
                .range(2, x - 1)
                .noneMatch(e -> x % e == 0);
    }
    boolean isPalindrome() {
        return false;
    }
    public int divisor_sum(int n) {
        return IntStream.range(1, n + 1).filter(e -> n % e == 0).sum();
    }
    boolean check(Object element) {
        return element instanceof PerformOperation;
    }
}