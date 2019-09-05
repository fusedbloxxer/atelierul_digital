package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String LOCATION = "C:\\Users\\AnonymousClass\\WorkFolder\\GIT\\atelierul_digital\\Extra\\Practice\\Anagram\\words.txt";

    public static void main(String[] args) {
        AnagramGenerator myGenerator = new AnagramGenerator();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(LOCATION)))) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Z:\\TRASH\\anagram.txt"));
            while (scanner.hasNext()) {
                myGenerator.generate(scanner.next());
                bufferedWriter.write(myGenerator.anagramsToString());
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " : " + ex.getMessage());
        }
    }
}

interface Generator<T extends String> {
    List<T> generate(T elem);
}

class AnagramGenerator implements Generator {
    private List<String> anagrams;
    private int[] currentAnagram;
    private String word;

    AnagramGenerator() {
        this.anagrams = new ArrayList<>();
    }

    @Override
    public List<String> generate(String elem) {
        word = elem;
        currentAnagram = new int[word.length()];
        clean();
        backtracking(0);
        return anagrams;
    }

    private void backtracking(int k) {
        boolean isValid;
        int i;
        for (i = 0; i < word.length(); i++) {
            isValid = true;
            currentAnagram[k] = i;

            for (int j = 0; j < k; j++) {
                if (currentAnagram[j] == currentAnagram[k]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid && k < word.length()) {
                if (word.length() - 1 == k) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j : currentAnagram) {
                        stringBuilder.append(word.charAt(j));
                    }
                    String output = stringBuilder.toString();
                    if (!anagrams.contains(output)) {
                        anagrams.add(output);
                    }
                } else {
                    backtracking(k + 1);
                }
            }
        }
    }

    public void printAnagrams() {
        System.out.println("Word: " + word + "\nAnagrams:");
        anagrams.forEach(System.out::println);
        System.out.println();
    }

    public String anagramsToString() {
        StringBuilder stringBuilder = new StringBuilder("Word: " + word + "\nAnagrams:");
        anagrams.forEach(anagram -> stringBuilder.append(anagram).append(" "));
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public List<String> getAnagrams() {
        return anagrams;
    }

    private void clean() {
        anagrams.clear();
    }
}