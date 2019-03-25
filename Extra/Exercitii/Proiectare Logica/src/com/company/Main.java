package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Random rnd = new Random();

        FileWriter fileWriter = new FileWriter("MODELE EXAMEN PROIECTARE LOGICA.rtf");
        int i = 0;
        while (i < 100) {
            fileWriter.write("                        MODEL EXAMEN " + (i + 1) +  "\n\n");
            boolean[] problemTypes = new boolean[5];
            for(int j = 0; j < 3; j++) {
                int choice;
                do{
                    choice = rnd.nextInt(5);
                }while(problemTypes[choice]);
                problemTypes[choice] = true;

                fileWriter.write("EXERCITIUL " + (j + 1) +":\n" +
                        ProblemFactory
                              .getInstance()
                              .getProblem(choice)
                              .generate() + "\n\n");
            }
            i++;
        }
        fileWriter.close();
    }
}
interface Problem {
    String generate();
    default String generatePolarities(int length) {
        StringBuilder strings = new StringBuilder();
        while(length-- != 0) {
            Random rnd = new Random();
            if(rnd.nextInt(2) == 1)
                strings.append("+");
            else
                strings.append("-");
        }
        return strings.toString();
    }
    default String generateHexNumbers(int length, boolean JK) {
        StringBuilder strings = new StringBuilder();
        Random rnd = new Random();
        int number;

        while(length-- != 0) {
            if(JK)
            {
                number = rnd.nextInt(14);
            }
            else
                number = rnd.nextInt(12);

            if(number < 10) {
                strings.append(number);
            } else {
                switch(number) {
                    case 10: strings.append('A');
                        break;
                    case 11: strings.append('B');
                        break;
                    case 12: strings.append('C');
                        break;
                    case 13: strings.append('D');
                        break;
                    case 14: strings.append('E');
                        break;
                    case 15: strings.append('F');
                        break;
                }
            }
        }
        return strings.toString();
    }
    default String generateSequence(int Length, int Cycles) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] digits = new boolean[Length];
        Random rnd = new Random();
        boolean check = false;
        int remember = 0;

        while (Length != 0) {
            int index = rnd.nextInt(digits.length);
            while (index == remember) {
                index = rnd.nextInt(digits.length);
            }
            if(!check) {
                remember = index;
                check = true;
            }
            if(digits[index]) {
                if(stringBuilder.charAt(stringBuilder.length() - 1) != ' ')
                    stringBuilder
                            .append(remember)
                            .append("; ");
                check = false;
            } else {
                stringBuilder
                        .append(index)
                        .append("-");
                Length--;
                digits[index] = true;
            }
        }

        stringBuilder
                .append(remember)
                .append(";");

        if(stringBuilder.toString().split(";").length > Cycles)
            generateSequence(digits.length, Cycles);
        return stringBuilder.toString();
    }
}
class SynchronousCounter implements Problem {

    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        int count = 0;
        while(count < 3) {
            if(rnd.nextInt(2) == 1) {
                stringBuilder.append("JK");
            } else {
                stringBuilder.append("D");
            }
            count++;
            if(count < 3)
                stringBuilder.append(",");
        }
        stringBuilder.replace(0, stringBuilder.length(), "Proiectati un numarator cu 3BB de tip (" + stringBuilder + ") in \n" +
                "ordinea 0-2 care sa numere conform diagramei: \n");
        return
                stringBuilder
                        .append(generateSequence(8, 3))
                        .append(" (6p)")
                        .toString();
    }
}
class SynchronousAuto implements Problem {
    public String generate() {
        return ("Proiectati un automat cu 2BB de tip D si 2 " + "semnale de control X si Y care sa functioneze conform " + "diagramelor: \nXY=00 --> ") +
                generateSequence(4, 2) +
                "\nXY=01 --> " +
                generateSequence(4, 2) +
                "\n" + "XY=10 --> " +
                generateSequence(4, 2) +
                "\nXY=11 --> " +
                generateSequence(4, 2) + "\n            (fara" + " schema). (6p)\n";
    }
}
class Table implements Problem {
    public String generate() {
        Deque<String> params = new ArrayDeque<>();
        Random rnd = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int randomized = rnd.nextInt(4);

        switch (randomized) {
            case 0: {
                params.push("D");
                params.push((rnd.nextInt(2) == 1)?"+":"-");
                params.push(Integer.toString(rnd.nextInt(2)));
                params.push("SRDC=" + generateHexNumbers(12, false));
            } break;
            case 1: {
                params.push("T");
                params.push((rnd.nextInt(2) == 1)?"+":"-");
                params.push(Integer.toString(rnd.nextInt(2)));
                params.push("SRTC=" + generateHexNumbers(12, false));
            } break;
            case 2: {
                params.push("JK");
                params.push((rnd.nextInt(2) == 1)?"+":"-");
                params.push(Integer.toString(rnd.nextInt(2)));
                params.push("Semnalul S=0. ");
                params.push("RJKC=" + generateHexNumbers(12, true));
            } break;
            case 3: {
                params.push("JK");
                params.push((rnd.nextInt(2) == 1)?"+":"-");
                params.push(Integer.toString(rnd.nextInt(2)));
                params.push("Semnalul R=0. ");
                params.push("SJKC=" + generateHexNumbers(12, true));
            }break;
        }

        stringBuilder
                .append("Fie un BB de tip ")
                .append(params.pollLast())
                .append(" sensibil la tranzitia \"")
                .append(params.pollLast())
                .append("\" a semnalului de\n" +
                        "ceas C. Starea initiala a BB este Q=").append(params.pollLast()).append(". ");
        if(randomized > 1) {
            stringBuilder.append(params.pollLast());
        }
        stringBuilder
                .append("Semnalele\n" + "de intrare evolueaza in ordinea: ")
                .append(params.pollLast()).append(". Care este\n")
                .append("secventa de stari pentru iesirea Q a acestui BB? (3p)");

        return stringBuilder.toString();
    }
}
class Display implements Problem {
    public String generate() {
        boolean[] digits = new boolean[4];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        stringBuilder
                .append("Un numarator numara conform diagramei ")
                .append(generateSequence(16, 11))
                .append(". ")
                .append("Daca un afisor cu 7 segmente este conectat ")
                .append("astfel incat : \n");
        for(int i = 0; i < 4; i ++) {
            stringBuilder
                    .append("I")
                    .append(i)
                    .append("=");
            if(rnd.nextInt(2) == 1) {
                stringBuilder.append("!");
            }
            stringBuilder.append("Q");
            int randomize;
            do {
                 randomize = rnd.nextInt(4);
            } while(digits[randomize]);
            digits[randomize] = true;

            stringBuilder.append(randomize);
            if(i + 1 < 4)
                stringBuilder.append(", ");
        }
        stringBuilder.append(" ce ordine " +
                "de numarare va indica acest numarator. (3p)");
        return stringBuilder.toString();
    }
}
class Temporal implements Problem {


    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        int randomize = (new Random()).nextInt(2);
        String tipBB, polaritati, conexiuni;
        int BB, nrPerioade, stareInceput;
        char semnalClock;

        if(randomize == 1) {
            BB = 4;
            tipBB = "T";
            nrPerioade = 17;
            stareInceput = (new Random()).nextInt(16);

            boolean digits[] = new boolean[4];
            Random rnd = new Random();
            randomize = rnd.nextInt(4);


            for(int i = 0; i < 4; i ++) {

                stringBuilder
                        .append("CK")
                        .append(i)
                        .append("=");

                if(randomize == i) {
                    stringBuilder.append("CLOCK");
                } else {
                    int check;
                    do{
                        check = rnd.nextInt(4);
                    }while(digits[check]);
                    digits[check] = true;
                    if(rnd.nextInt(2) == 1)
                        stringBuilder.append("!");

                    stringBuilder
                            .append("Q")
                            .append(check);
                }
                if(i + 1 < 4) {
                    stringBuilder.append("; ");
                }
            }

        } else {
            BB = 3;
            tipBB = "JK";
            nrPerioade = 6;
            stareInceput = (new Random()).nextInt(8);

            Random rnd = new Random();
            int remember1 = rnd.nextInt(3), remember2 = rnd.nextInt(3);

            for(int i = 0; i < 3; i ++) {

                stringBuilder
                        .append("J")
                        .append(i)
                        .append("=");

                int check;
                do{
                    check = rnd.nextInt(3);
                }while(check == i && check != remember1);
                if(rnd.nextInt() == 1)
                    stringBuilder.append("!");
                if(rnd.nextInt(101) == 0) {
                    stringBuilder.append(1);
                } else
                stringBuilder
                        .append("Q")
                        .append(check);

                remember1 = check;

                stringBuilder.append("; ");

                stringBuilder
                        .append("K")
                        .append(i)
                        .append("=");
                do{
                    check = rnd.nextInt(3);
                }while(check == i && check != remember2 && check != remember1);

                if(rnd.nextInt(2) == 1)
                    stringBuilder.append("!");
                stringBuilder
                        .append("Q")
                        .append(check);
                remember2 = check;

                if(i + 1 < 3) {
                    stringBuilder.append("; ");
                }
            }
        }

        polaritati = generatePolarities(BB);
        conexiuni = stringBuilder.toString();
        semnalClock = ((new Random()).nextInt(2) == 1)?'H':'L';

        stringBuilder = new StringBuilder();
        stringBuilder
                .append("Fie un sistem de ")
                .append(BB)
                .append(" BB de tip ")
                .append(tipBB);
        if(tipBB.equals("T"))
            stringBuilder.append(" adusi in regim de toggle");
        stringBuilder
                .append(", numerotati de la 0-")
                .append(BB - 1)
                .append(", ale caror intrari de CK au polaritatile: ")
                .append(polaritati)
                .append(". Sistemul devine un numarator daca facem urmatoarele " +
                        "conexiuni: ")
                .append(conexiuni)
                .append(" Desenati " + "schema electronica a acestui numarator. Desenati formele de " + "unda pentru semnalele CLOCK, Q0, Q1, Q2 si Q3 pentru ")
                .append(nrPerioade).append(" ").append("perioade ale semnalului de ceas, incepand cu starea ")
                .append(stareInceput).append("  pe ")
                .append("semiperioada cand semnalul de clock este ")
                .append(semnalClock).append(". (6p)");

        return stringBuilder.toString();
    }
}
class ProblemFactory {
    private static final ProblemFactory INSTANCE = new ProblemFactory();
    private ProblemFactory() {}
    Problem getProblem(int type) {
        switch(type) {
            case 0:
                return new SynchronousCounter();
            case 1:
                return new SynchronousAuto();
            case 2:
                return new Table();
            case 3:
                return new Display();
            case 4:
                return new Temporal();
        }
        return null;
    }
    static ProblemFactory getInstance() {
        return INSTANCE;
    }
}