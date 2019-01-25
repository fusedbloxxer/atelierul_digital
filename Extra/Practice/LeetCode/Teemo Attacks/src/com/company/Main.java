package com.company;

public class Main {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 1;
        if(timeSeries.length == 1)
        {
            return 2;
        }
        else
        {
            duration = 2;
            for(int i = 1; i < timeSeries.length; i++)
            {
                if(timeSeries[i] == timeSeries[i - 1] + 1)
                {
                    duration += 1;
                    count++;
                }
                else
                    duration += 2;
            }
        }
        return duration;
    }

    public static void main(String[] args) {
        int timeSeries[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findPoisonedDuration(timeSeries, 1));
    }
}
