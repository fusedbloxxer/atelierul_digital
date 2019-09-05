package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("School A", 255);
        Pair<String, Integer> pair2 = new Pair<>("School A", 255);

        System.out.println(pair1.compareTo(pair2) > 0);
        print("25", 4);

        Exchange.getInstance().addRate(RON.class, USD.class, 4.1d);
        Exchange.getInstance().addRate(RON.class, Pound.class, 5.6d);
        RON lei = new RON(1_000);
        USD dollar = (USD) Exchange.getInstance().convert(lei, USD.class);
        lei = (RON) Exchange.getInstance().convert(dollar, RON.class);

        System.out.println(dollar.money);
    }

    private static <T> void print(T... elements) {
        for (T elem : elements) {
            System.out.println(elem);
        }
    }
}

class Exchange<T extends Currency, C extends Class<T>> {
    private static Exchange INSTANCE;

    private Exchange() {
        mapMap = new HashMap<>();
    }

    public static Exchange getInstance() {
        if (INSTANCE == null) {
            synchronized (Exchange.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Exchange();
                }
            }
        }
        return INSTANCE;
    }

    private Map<C, Map<C, Double>> mapMap;

    @Deprecated
    T convert(T currency, C newClass) {
        try {
            T clone = (T) newClass.newInstance();
            clone.money = currency.money * mapMap.get(currency.getClass()).get(newClass);
            return clone;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    void addRate(C firstClass, C secondClass, Double rate) {
        if (!mapMap.containsKey(firstClass)) {
            mapMap.put(firstClass, new HashMap<>());
        }

        mapMap.get(firstClass).put(secondClass, 1 / rate);

        if (!mapMap.containsKey(secondClass)) {
            mapMap.put(secondClass, new HashMap<>());
        }

        mapMap.get(secondClass).put(firstClass, rate);
    }
}

class Currency {
    double money;

    Currency(double money) {
        this.money = money;
    }

    Currency() {

    }
}

class RON extends Currency {

    RON(double money) {
        super(money);
    }

    RON() {

    }
}

class Pound extends Currency {

    Pound(double money) {
        super(money);
    }

    Pound() {

    }
}

class USD extends Currency {

    USD(double money) {
        super(money);
    }

    USD() {

    }
}

class Pair<K, V> implements Comparable<Pair<K, V>> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        return getKey().equals(o.getKey()) && getValue().equals(o.getValue()) ? 1 : 0;
    }
}

class Util {
    public static <K, V> boolean compare(Pair<K, V> pair, Pair<K, V> pair2) {
        return pair.getKey().equals(pair2.getKey()) &&
                pair.getValue().equals(pair2.getValue());
    }
}