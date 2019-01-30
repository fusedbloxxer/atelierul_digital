package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    // 1. Mapa: Element : numar de aparitii
    // 2. Verificarea ratiei(pereche unica!)
    // 3. Inmultirea nr de aparitii
    // 4. Insumare si afisare

    private static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> map = new TreeMap<>();

        arr.forEach(element -> {
                    if(map.containsKey(element)) {
                        map.put(element, map.get(element) + 1);
                    } else {
                        map.put(element, 1L);
                    }
                });

        if(r == 1) {
            map.forEach((x, y) -> SumHelper.getInstance().increaseValue(y * (y - 1) * (y - 2) / 6));
        } else {
            map.forEach((x, y) -> {
                if(map.containsKey(x * r)) {
                    if(map.containsKey(x * r * r)) {
                        System.out.println("(" + x + ", " + (x * r) + ", " + (x *r * r) + ") -> " + y * map.get(x * r) * map.get(x * r * r));
                        SumHelper
                                .getInstance()
                                .increaseValue(y * map.get(x * r) * map.get(x * r * r));
                    }
                }
            });
        }
        return SumHelper
                        .getInstance()
                        .getValue();
    }
    private static long countTriplets2(List<Long> arr, long r) {
        Map<Long, List<Pair>> map = new HashMap<>();

        for(int i = arr.size() - 1; i >= 0; i--) {
            if(map.containsKey(arr.get(i))) {
                map
                        .get(arr.get(i))
                        .add(new Pair(i, map.get(arr.get(i)).get(map.get(arr.get(i)).size() - 1).count + 1));
            } else {
                List<Pair> pairs = new ArrayList<>();
                pairs.add(new Pair(i, 1));
                map.put(arr.get(i), pairs);
            }
        }

        map
                .forEach((x, y) -> {
                    System.out.println(x + ":");
                    y.forEach(element -> {
                        // System.out.println("    " + element.index + ": " + element.count);
                        if(map.containsKey(x * r)) {
                            map
                                    .get(x * r)
                                    .forEach(element2 -> {
                                        if()
                                    });
                        }
                    });
                });

        return SumHelper
                .getInstance()
                .getValue();
    }
    public static void main(String[] args) throws IOException{
        List<Long> longList = new ArrayList<>();
        long r = ReadTestCase
                            .getInstance()
                            .readFile(longList);

        System.out.println(countTriplets2(longList, r));
    }
}
class Pair {
    int index = 0;
    long count = 0;
    Pair(int index, long count) {
        this.index = index;
        this.count = count;
    }
}
class SumHelper {
    private static final SumHelper INSTANCE = new SumHelper();
    private long value = 0L;
    void increaseValue(Long value) {
        this.value += value;
    }
    Long getValue() {
        return this.value;
    }
    public static SumHelper getInstance() {
        return INSTANCE;
    }
    private SumHelper() {}
}
class ReadTestCase {
    private ReadTestCase() {}
    private static final ReadTestCase INSTANCE = new ReadTestCase();
    long readFile(List<Long> longList) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("test.txt")));
        long N = s.nextLong();
        long r = s.nextLong();

        while(N-- != 0) {
            longList.add(s.nextLong());
        }
        return r;
    }
    public static ReadTestCase getInstance() {
        return INSTANCE;
    }
}