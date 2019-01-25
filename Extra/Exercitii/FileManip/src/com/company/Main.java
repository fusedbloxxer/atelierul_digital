package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main{

    private static byte[] readFile(String Path) throws IOException {
        System.out.println("Received text from -> " + Path);

        RandomAccessFile randomAccessFile = new RandomAccessFile(Path, "r");
        byte[] bytes = new byte[(int) randomAccessFile.length()];
        randomAccessFile.read(bytes);
        randomAccessFile.close();

        return bytes;
    }

    private static void writeFile(String Path, String newText){

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

    private static String OpenFiles(StringBuilder UsedPath){

        try {

            //Print the availabe paths(that were previously read
            int Option = 0;
            String home = "paths.txt";
            String newPath = null;

            if (Files.exists(Paths.get(home))) {

                String[] FilePaths = (new String(readFile(home))).split("\\+");

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

    private static void TopWords(String Text, List<Integer> Apparitions, List<String> WordList, int Size) {

        String[] Modified=Text.split(" |\\,|\\.|\\!|\\?|\\'");

        for(int index1=0;index1<Modified.length;index1++)
        {
            if(Modified[index1].length()>0)
            {
                boolean check=false;
                for(int index2=0;index2<WordList.size();index2++)
                    if(WordList.get(index2).equals(Modified[index1])){Apparitions.set(index2, Apparitions.get(index2) + 1); check=true; index2=WordList.size();}

                if(!check)
                {
                    WordList.add(Modified[index1]);
                    Apparitions.add(1);
                }
            }
        }

        //Bubble Sort
        boolean ok;

        do {
            ok=false;
            for(int index=0;index<WordList.size()-1;index++) {
                if (Apparitions.get(index) < Apparitions.get(index+1)) {

                    int aux = Apparitions.get(index);
                    Apparitions.set(index, Apparitions.get(index + 1));
                    Apparitions.set(index + 1, aux);

                    String Aux2 = WordList.get(index);
                    WordList.set(index, WordList.get(index + 1));
                    WordList.set(index+1, Aux2);

                    ok = true;

                } else {

                    if (Apparitions.get(index).equals(Apparitions.get(index+1)) & WordList.get(index).compareTo(WordList.get(index + 1)) > 0) {

                        int aux = Apparitions.get(index);
                        Apparitions.set(index, Apparitions.get(index + 1));
                        Apparitions.set(index + 1, aux);

                        String Aux2 = WordList.get(index);
                        WordList.set(index, WordList.get(index + 1));
                        WordList.set(index+1, Aux2);

                        ok=true;
                    }
                }
            }
        }while(ok);

        if(Size!=-1)
            for(int index=WordList.size()-1;index>Size;index--)
                WordList.remove(index);
    }

    private static int[] SPQ(String Text) {

        int[] Structure=new int[3];
        char[] text=Text.toCharArray();

        for(char u:text)if(u=='"')Structure[2]++;
        Structure[2]/=2;

        String[] PH = Text.split("\\.");
        int N=PH.length;

        for(int index=0;index<N;index++)
        {
            if((PH[index].split(" ")).length>=10) Structure[1]++;
            else Structure[0]++;
        }

        return Structure;
    }

    private static String removePunctuation(String Text, String Separator) {

        char[] NewText=Text.toCharArray();
        char[] separator=Separator.toCharArray();
        int N=NewText.length;

        for(int index=0;index< N;index++)
        {
            boolean check=false;

            for(char u:separator)
            {
                if(NewText[index]==u)check=true;
            }

            if(check)
            {
                System.arraycopy(NewText,index+1,NewText, index, NewText.length-index-1);
                //for(int index2=index;index2<N-1;index2++)
                //  NewText[index2]=NewText[index2+1];
                index--;
                N--;
            }
        }

        return new String(java.util.Arrays.copyOfRange(NewText,0, N));
    }

    public static void main(String[] args) {

        StringBuilder CurrentPath = new StringBuilder();
        int option=0;
        CryptPair Date = new CryptPair(OpenFiles(CurrentPath), 0);
        CryptPair Undo=new CryptPair(Date.F, Date.I);

        do {
            System.out.print("0.Print Current File\n1.Save File\n2.Encrypt Text\n3.Decrypt Text\n4.Top 10 words\n5.Get sorted dictionary\n6.Number of quotations, sentences and phrases\n7.Remove punctuation\n\nExit\n\n:");

            try {
                option = (new Scanner(System.in)).nextInt();
            }catch (NoSuchElementException ex)
            {
                System.out.println("Exception occurred: " + ex.getMessage() + " Cause: " + ex.getCause());
            }


            switch (option) {
                case -1:
                {
                    Date.setF(Undo.F);
                    Date.setI(Undo.I);

                    System.out.println("Undo applied. Current file is: \n" + Date.F);
                }
                break;
                case 0:
                {
                    System.out.println(Date.F);
                }
                break;
                case 1:
                {
                    writeFile(CurrentPath.toString(), Date.getF());
                    System.out.println("Changes saved to the file.");
                }
                break;
                case 2: {

                    Undo.setF(Date.F);
                    Undo.setI(Date.I);

                    Encrypt(Date);
                    //writeFile(CurrentPath.toString(), Date.getF());
                    System.out.println(Date.F + "\n" + "The KEY is " + Date.I + " WRITE IT DOWN OR THE DATA WILL BE LOST!");
                }
                break;
                case 3: {

                    Undo.setF(Date.F);
                    Undo.setI(Date.I);

                    System.out.println("The KEY is: ");
                    Date.setI((new Scanner(System.in)).nextInt());
                    Decrypt(Date);
                    //writeFile(CurrentPath.toString(), Date.getF());
                    System.out.println(Date.F + "\n" + "The KEY is " + Date.I);
                }
                break;
                case 4:
                {
                    List<Integer> TopApparitions =new ArrayList<>();
                    List<String> Words=new ArrayList<>();

                    TopWords(Date.F, TopApparitions, Words, 10);
                    System.out.println("The Most Used Words Are: ");
                    for(int index=0;index<Words.size();index++)
                        System.out.println((index+1) + "." + Words.get(index) + ":" + TopApparitions.get(index));
                    System.out.println();
                }
                break;
                case 5:
                {
                    List<Integer> TopApparitions =new ArrayList<>();
                    List<String> Words=new ArrayList<>();

                    TopWords(Date.F, TopApparitions, Words, -1);
                    System.out.println("Dictionary: ");

                    for(int index=0;index<Words.size();index++)
                        System.out.println((index+1) + "." + Words.get(index) + ":" + TopApparitions.get(index));
                    System.out.println();
                }
                break;
                case 6:
                {
                    int[] spq = SPQ(Date.F);
                    System.out.println("Sentences: " + spq[0] + " Phrases: " + spq[1] + " Quotations: " + spq[2]);
                }
                break;
                case 7:
                {
                    Undo.setF(Date.F);
                    Undo.setI(Date.I);

                    System.out.print("Enter the characters that you want removed from the file(or DEF for  '.,?!\"): ");
                    String Separator=(new Scanner(System.in)).nextLine();

                    if(Separator.equals("DEF"))Separator=" !'.,?\"";
                    Date.F=removePunctuation(Date.F,Separator);
                    System.out.println(Date.F);
                }
                break;
                default:
                    System.out.println("Exiting program . . .");
                    break;
            }

        } while (option >= -1 && option <= 7);

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