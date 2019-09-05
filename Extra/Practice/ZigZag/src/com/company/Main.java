package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 3, 2));
        Collections.sort(list);
        Deque<Integer> deque = new ArrayDeque<>(list);
        list.clear();

        while (deque.size() > 0) {
            if (deque.size() > 0) {
                list.add(deque.removeFirst());
            }
            if (deque.size() > 0) {
                list.add(deque.removeLast());
            }
        }

        list.forEach(elem -> System.out.print(elem + " "));

        List<String> list1 = new ArrayList<>(Arrays.asList("Andrei este la scoala".toLowerCase().split(" ")));
        Collections.sort(list1);
        List<String> list2 = new ArrayList<>(Arrays.asList("Mihai sta si mananca mere cu pofta la el in camera".toLowerCase().split(" ")));
        Collections.sort(list2);

        mergeLists(list1, list2).forEach(el -> System.out.print(el + " "));
    }

    private static <T extends Comparable<T>> List<T> mergeLists(List<T> firstList, List<T> secondList) {
        List<T> merged = new ArrayList<>();

        int firstIndex = 0, secondIndex = 0;

        while (firstIndex < firstList.size() && secondIndex < secondList.size()) {
            if (firstList.get(firstIndex).compareTo(secondList.get(secondIndex)) <= 0) {
                merged.add(firstList.get(firstIndex++));
            } else {
                merged.add(secondList.get(secondIndex++));
            }
        }

        while (firstIndex < firstList.size()) {
            merged.add(firstList.get(firstIndex++));
        }

        while (secondIndex < secondList.size()) {
            merged.add(secondList.get(secondIndex++));
        }

        return merged;
    }
}
