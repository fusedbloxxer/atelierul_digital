package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static byte[] readFile(String Path) throws IOException {
        System.out.println("Received text from -> " + Path);

        RandomAccessFile randomAccessFile = new RandomAccessFile(Path, "r");
        byte[] bytes = new byte[(int) randomAccessFile.length()];
        randomAccessFile.read(bytes);
        randomAccessFile.close();

        return bytes;
    }

    private static void writeFile(String Path, String newText) {

        try {
            Files.write(Paths.get(Path), (newText).getBytes());
        } catch (IOException ex) {
            StackTraceElement[] stackTraceElement = ex.getStackTrace();
            System.out.println("An exception occurred: " + ex.getMessage() + " Cause: " + ex.getCause() + ".");

            System.out.println("Stack Trace: ");
            if (stackTraceElement.length > 0) {
                for (StackTraceElement current : stackTraceElement)
                    System.out.println(current.getMethodName() + "()" + " Line: " + current.getLineNumber());
            }
        }
    }

    private static String OpenFiles(StringBuilder UsedPath) {
        try {
            //Print the availabe paths(that were previously read
            int Option = 0;
            String home = "paths.txt";
            String newPath = null;

            if (Files.exists(Paths.get(home))) {

                String[] FilePaths = (new String(readFile(home))).split("\\+");
                System.out.println("Last used paths: ");

                System.out.println("(0)Insert new path");
                for (int index = 1; index <= FilePaths.length; index++) {
                    System.out.println("(" + index + ")" + FilePaths[index - 1]);
                }

                System.out.print("Enter your option: ");
                Option = (new Scanner(System.in).nextInt());

                if (Option < 1 || Option > FilePaths.length) Option = 0;
                else newPath = FilePaths[Option - 1];

            }
            //Option: if the user chooses to introduce a new path, save it then proceed.

            if (Option == 0) {

                System.out.println("Enter the path of your input file: ");
                Scanner s = new Scanner(System.in);
                newPath = s.nextLine();
                s.close();

                if (Files.exists(Paths.get(home))) {

                    boolean check = false;
                    String[] FilePaths = (new String(readFile(home))).split("\\+");
                    for (int index = 0; index < FilePaths.length; index++) {
                        if (newPath.equals(FilePaths[index])) {
                            index = FilePaths.length;
                            check = true;
                        }
                    }

                    if (!check) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(home, "rw");
                        randomAccessFile.seek(randomAccessFile.length());
                        randomAccessFile.write(("+" + newPath).getBytes());
                        randomAccessFile.close();
                    }
                } else {
                    Files.write(Paths.get(home), (newPath).getBytes());
                }
            }

            //System.out.println(new String(readFile(newPath)));
            UsedPath.replace(0, newPath.length(), newPath);
            return new String(readFile(newPath));


        } catch (IOException ex) {
            StackTraceElement[] stackTraceElement = ex.getStackTrace();
            System.out.println("An exception occurred: " + ex.getMessage() + " Cause: " + ex.getCause() + ".");

            System.out.println("Stack Trace: ");
            if (stackTraceElement.length > 0) {
                for (StackTraceElement current : stackTraceElement)
                    System.out.println(current.getMethodName() + "()" + " Line: " + current.getLineNumber());
            }

            //UsedPath.replace(0, 0, null);
            return "-1";
        }
    }

    private static void Encrypt(CryptPair Info) {
        Random rnd = new Random();
        Info.setI(rnd.nextInt());

        char[] list = Info.F.toCharArray();
        int N = Info.F.length();

        for (int index = 0; index < N; index++)
            list[index] = (char) (list[index] - '0' + Info.I + index);

        Info.setF(new String(list));
    }

    private static void Decrypt(CryptPair Info) {
        char[] list = Info.F.toCharArray();
        int N = Info.F.length();

        for (int index = 0; index < N; index++)
            list[index] = (char) (list[index] + '0' - Info.I - index);

        Info.setF(new String(list));
        //return Info;
    }

    public static void main(String[] args) {

        System.out.println("Receiving text . . .");

        StringBuilder CurrentPath = new StringBuilder();
        int option;
        CryptPair Date = new CryptPair(OpenFiles(CurrentPath), 0);
        System.out.println(CurrentPath);

        do {

            System.out.println("1. Encrypt Text\n2.Decrypt Text\n3.Top 10 words\n4.Get sorted dictionary\nExit\n\n");
            System.out.print(":");
            option = (new Scanner(System.in)).nextInt();


            switch (option) {
                case 1: {
                    Encrypt(Date);
                    writeFile(CurrentPath.toString(), Date.getF());
                    System.out.println(Date.F + "\n" + "The KEY is " + Date.I + "\n WRITE IT DOWN OR THE DATA WILL BE LOST!");
                }
                break;

                case 2: {
                    System.out.println("The KEY is: ");
                    Date.setI((new Scanner(System.in)).nextInt());

                    Decrypt(Date);
                    writeFile(CurrentPath.toString(), Date.getF());
                    System.out.println(Date.F + "\n" + "The KEY is " + Date.I);
                }
                break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Exiting program . . .");
                    break;
            }

        } while (option >= 1 && option <= 4);

        System.out.print("Closed: " + CurrentPath);


    }

    static class CryptPair {
        String F;
        Integer I;

        private CryptPair(String NEW, Integer NEW2) {
            F = NEW;
            I = NEW2;
        }

        private void setI(Integer i) {
            I = i;
        }

        private String getF() {
            return F;
        }

        private void setF(String f) {
            F = f;
        }
    }
}