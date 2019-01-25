package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<List<Integer>> backTracking(int k, int nums[], int arr[], int count, List<List<Integer>> permutations)
    {
        if(k < nums.length)
        {
            for(int i = 0; i < nums.length; i++)
            {
                int ok = 0;
                arr[k] = i;
                for(int j = 0; j < k; j++)
                {
                    if(arr[j] == i)
                    {
                        ok = 1;
                        j = k;
                    }
                }

                if(ok == 0)
                {
                    backTracking(k + 1, nums, arr, count, permutations);
                }
            }
        }
        else
        {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < k ; i++)
                list.add(nums[arr[i]]);
            permutations.add(list);
            if(++count == nums.length)
            {
                return permutations;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int N;

        Scanner s = new Scanner(System.in);
        N = s.nextInt();

        int[] nums, arr;
        nums = new int[N];
        arr  = new int[N];

        for(int i = 0; i < N; i++)
        {
            nums[i] = i + 1;
        }

        List<List<Integer>> permutations = new ArrayList<>();
        backTracking(0, nums, arr, 0, permutations);
        permutations.forEach(list -> {
            list.forEach(element -> {
                System.out.print(element + " ");
            });
            System.out.println();
        });
    }
}
