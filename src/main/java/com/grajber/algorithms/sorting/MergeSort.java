package com.grajber.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] nums = {67, 23, 89, 234, 12, 5, 3, 7, 3, 123, 789, 34, 567312, 134, 6452, 123, 54, 67};
        System.out.println(Arrays.toString(nums));
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int p, int r) {

        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(nums, p, q);
        mergeSort(nums, q + 1, r);
        merge(nums, p, q, r);
    }

    private static void merge(int[] nums, int p, int q, int r) {

        int lSize = q - p + 1;
        int rSize = r - q;

        int[] lNums = new int[lSize];
        int[] rNums = new int[rSize];

        for (int i = 0; i < lSize; i++)
            lNums[i] = nums[p + i];
        for (int j = 0; j < rSize; j++)
            rNums[j] = nums[q + 1 + j];

        int i = 0;
        int j = 0;
        int k = p;

        while (i < lSize && j < rSize) {
            if (lNums[i] <= rNums[j]) {
                nums[k] = lNums[i];
                i++;
            } else {
                nums[k] = rNums[j];
                j++;
            }
            k++;
        }

        while (i < lSize) {
            nums[k] = lNums[i];
            i++;
            k++;
        }

        while (j < rSize) {
            nums[k] = rNums[j];
            j++;
            k++;
        }
    }
}
