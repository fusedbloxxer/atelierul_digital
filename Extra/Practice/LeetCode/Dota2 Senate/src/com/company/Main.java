package com.company;

public class Main {

    public static void printChange(byte[] ban, char[] arr, int N, int banned, int voter)
    {
        for(int i = 0; i < N; i++)
        {
            if(i == voter)
                System.out.print("V ");
            else if(i == banned)
                    System.out.print("B ");
            else System.out.print(arr[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < N; i++)
        {
            System.out.print(ban[i] + " ");
        }
        System.out.println();
    }

    public static String predictPartyVictory(String senate) {
            int N = senate.length(), R = 0, D = 0;
            byte[] ban = new byte[N];
            char[] arr = senate.toCharArray();

            for(int i = 0; i < N; i++)
            {
                if(ban[i] == 0)
                {
                    if(arr[i] == 'R') {
                        R++;
                        for (int j = 0; j < N; j++) {
                            if (arr[j] == 'D' && ban[j] == 0) {
                                ban[j] = 1;
                                D--;
                                printChange(ban, arr, N, i, j);
                                break;
                            }
                        }
                    } else {
                        D++;
                        for (int j = 0; j < N; j++) {
                            if (arr[j] == 'R' && ban[j] == 0) {
                                ban[j] = 1;
                                R--;
                                printChange(ban, arr, N, i, j);
                                break;
                            }
                        }
                    }
                } else {
                    if(arr[i] == 'R')
                        R++;
                    else
                        D++;
                }
            }
            return "";
    }
    public static void main(String[] args) {
        predictPartyVictory("DRRDRDRDRDDRDRDR");
    }
}
