package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count < 0) {
            throw new ArithmeticException();
        } else {
            try (

            } catch (IOException ex) {
                System.out.println(ex.getMessage() + " : " + ex.getCause());
            }
        }
    }
}

interface Generate {
    String generate(int count);
    void writeToFile(String filePath) throws IOException;
}

class GenerateLeaders implements Generate {

    GenerateLeaders(int count) {}

    @Override
    public String generate(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(elem -> stringBuilder.append(elem).append(" "));

        return stringBuilder.toString();
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(new GenerateLeaders().generate(count));
    }
}
