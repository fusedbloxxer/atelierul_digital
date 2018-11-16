package com.company;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Main {

    private static void CopyText1(String readFileName, String writeFileName) throws IOException {
        FileReader fr = new FileReader(readFileName);
        FileWriter fw = new FileWriter(writeFileName);

        int c;
        while ((c = fr.read()) != -1) {
            System.out.print((char)c);
            fw.write((char)c);
        }

        fr.close();
        fw.close();
    }

    private static void CopyText2(String readFileName, String writeFileName) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(readFileName));
        BufferedWriter fw = new BufferedWriter(new FileWriter(writeFileName));

        int c;
        while ((c = fr.read()) != -1) {
            fw.write(c);
        }

        fr.close();
        fw.close();
    }

    public static void main(String[] args) {

        String pFile= "D:/GIT/Atelierul Google/atelierul_digital/2_4/src/com/company/text.txt";

        Instant start = Instant.now();

        try {
            CopyText1(pFile, "newFile.txt");
        } catch (Exception ex) {
            System.out.println("Nu ai creat unul din fisiere!" + "Error: " + ex.getMessage() + " Cause: " + ex.getCause() + "Suppressed Exception: " + ex.getSuppressed());
        }

        Instant finish = Instant.now();

        System.out.println("\nCopierea a durat: " + Duration.between(start, finish) + "\n");

        start = Instant.now();

        try {
            CopyText2(pFile, "newFile.txt");
        } catch (Exception ex) {
            System.out.println("Nu ai creat unul din fisiere!" + "Error: " + ex.getMessage() + " Cause: " + ex.getCause() + "Suppressed Exception: " + ex.getSuppressed());
        }

        finish = Instant.now();

        System.out.println("\nCopierea a durat: " + Duration.between(start, finish) + "\n");
    }
}
