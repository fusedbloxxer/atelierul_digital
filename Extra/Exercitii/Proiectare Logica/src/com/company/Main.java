package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    /*
    * Numarator Sincron:
    * D/JK => 3 bistabili, ordinea, si cum sa numere
    * */

    public static void main(String[] args) throws IOException {
        Problem a = new Temporal();
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
}
class Solver {
    String generatePolaritate(int length) {
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
    String generateHexNumbers(int length, boolean JK) {
        StringBuilder strings = new StringBuilder();
        Random rnd = new Random();
        int number;

        while(length-- != 0) {
            if(JK)
                number = rnd.nextInt(16);
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
    String generateSequence(int Length, int Cycles) {
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
                    stringBuilder.append(remember + "; ");
                check = false;
            } else {
                stringBuilder.append(index + "-");
                Length--;
                digits[index] = true;
            }
        }

        stringBuilder.append(remember +";");

        if(stringBuilder.toString().split(";").length > Cycles)
            generateSequence(digits.length, Cycles);
        return stringBuilder.toString();
    }
    StringBuilder stringBuilder;
    public String getExercise() {
        return stringBuilder.toString();
    }
}
class NumaratorSincron extends Solver implements Problem {

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
class AutomatSincron extends Solver implements Problem {
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Proiectati un automat cu 2BB de tip D si 2 " +
                "semnale de control X si Y care sa functioneze conform " +
                "diagramelor: \nXY=00 --> " + generateSequence(4, 2) + "\nXY=01 --> " + generateSequence(4, 2) + "\n" +
                "XY=10 --> " + generateSequence(4, 2) + "\nXY=11 --> " + generateSequence (4, 2) + "\n            (fara" +
                " schema). (6p)\n");
        return stringBuilder.toString();
    }
}
class Tabel extends Solver implements Problem {
    public String generate() {
        Deque<String> params = new ArrayDeque<>();
        Random rnd = new Random();
        stringBuilder = new StringBuilder();
        int randomized = rnd.nextInt(4);
        // D, T, JK
        // SRDC, SRTC, RJKC, SJKC
        // 12 numere
        // Q, T

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
                        "ceas C. Starea initiala a BB este Q=")
                .append(params.pollLast() + ". ");
        if(randomized > 1) {
            stringBuilder.append(params.pollLast());
        }
        stringBuilder.append("Semnalele\n" +
                "de intrare evolueaza in ordinea: " + params.pollLast() +". Care este\n" +
                "secventa de stari pentru iesirea Q a acestui BB? (3p)");

        return stringBuilder.toString();
    }
}
class Afisor extends Solver implements Problem {
    public String generate() {
        boolean[] digits = new boolean[4];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = false;
        }
        stringBuilder = new StringBuilder();
        Random rnd = new Random();
        stringBuilder.append("Un numarator numara conform diagramei " + generateSequence(16, 11) + ". " +
                "Daca un afisor cu 7 segmente este conectat " +
                "astfel incat : \n");
        for(int i = 0; i < 4; i ++) {
            stringBuilder.append("I" + i + "=");
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
class Temporal extends Solver implements Problem {
    Integer BB, nrPerioade, stareInceput;
    String tipBB;
    String polaritati;
    String conexiuni;
    Character semnalClock;

    @Override
    public String generate() {
        stringBuilder = new StringBuilder();
        int randomize = (new Random()).nextInt(2);

        if(randomize == 1) {
            BB = 4;
            tipBB = "T";
            nrPerioade = 17;
            stareInceput = (new Random()).nextInt(16);

            boolean digits[] = new boolean[4];
            Random rnd = new Random();
            randomize = rnd.nextInt(4);


            for(int i = 0; i < 4; i ++) {

                stringBuilder.append("CK" + i + "=");

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

                    stringBuilder.append("Q" + check);
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

            int digits[] = {0, 0 , 0};
            Random rnd = new Random();
            randomize = rnd.nextInt(4);

            for(int i = 0; i < 3; i ++) {

                stringBuilder.append("J" + i + "=");
                int check;
                do{
                    check = rnd.nextInt(3);
                }while(digits[check] > 1);
                digits[check]++;
                if(rnd.nextInt() == 1)
                    stringBuilder.append("!");
                stringBuilder.append("Q" + check);

                stringBuilder.append("; ");

                stringBuilder.append("K" + i + "=");
                do{
                    check = rnd.nextInt(3);
                }while(digits[check] > 1);
                digits[check]++;
                if(rnd.nextInt(2) == 1)
                    stringBuilder.append("!");
                stringBuilder.append("Q" + check);

                if(i + 1 < 3) {
                    stringBuilder.append("; ");
                }
            }
        }

        polaritati = generatePolaritate(BB);
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
        stringBuilder.append(", numerotati de la 0-" + BB +", ale caror intrari de CK au polaritatile: ")
                      .append(polaritati)
                      .append(". Sistemul devine un numarator daca facem urmatoarele " +
                                 "conexiuni: ")
                      .append(conexiuni)
                      .append(" Desenati " +
                                 "schema electronica a acestui numarator. Desenati formele de " +
                                 "unda pentru semnalele CLOCK, Q0, Q1, Q2 si Q3 pentru " + nrPerioade + " " +
                                 "perioade ale semnalului de ceas, incepand cu starea " + stareInceput + "  pe " +
                                 "semiperioada cand semnalul de clock este " + semnalClock +". (6p)");

        return stringBuilder.toString();
    }
}
class ProblemFactory {
    private static final ProblemFactory INSTANCE = new ProblemFactory();
    private ProblemFactory() {}
    Problem getProblem(int type) {
        switch(type) {
            case 0:
                return new NumaratorSincron();
            case 1:
                return new AutomatSincron();
            case 2:
                return new Tabel();
            case 3:
                return new Afisor();
            case 4:
                return new Temporal();
        }
        return null;
    }
    public static ProblemFactory getInstance() {
        return INSTANCE;
    }
}