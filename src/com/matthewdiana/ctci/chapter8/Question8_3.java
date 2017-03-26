package com.matthewdiana.ctci.chapter8;

import java.util.Arrays;

public class Question8_3 {

    public static void main(String[] args) {

        // n = 5, our magic index should be 2
        int a[] = {-4, -3, 0, 2, 7, 13};

        System.out.println(findMagicIndex(a));

        // non-distinct array of numbers
        int b[] = {-2, -2, -2, 0, 0, 4, 4, 7, 7};

        System.out.println(findMagicIndexND(b));
    }

    public static int findMagicIndex(int[] arr) {
        return findMagicIndex(arr, 0, arr.length - 1);
    }

    public static int findMagicIndexND(int[] arr) {
        return findMagicIndexND(arr, 0, arr.length - 1);
    }

    private static int findMagicIndex(int[] arr, int beg, int end) {
        if (beg > end) {
            // couldn't find the magic index :-(
            return Integer.MIN_VALUE;
        }

        int index = (beg + end) / 2;
        if (arr[index] == index) {
            return index;
        } else if (arr[index] < index) {
            return findMagicIndex(arr, index + 1, end);
        } else {
            return findMagicIndex(arr, beg, index - 1);
        }

    }

    private static int findMagicIndexND(int[] arr, int beg, int end) {
        if (beg > end) {
            // couldn't find the magic index :-(
            return Integer.MIN_VALUE;
        }

        int index = (beg + end) / 2;
        if (arr[index] == index) {
            return index;
        }

        int left = Math.min(index - 1, arr[index]);
        int leftIndex = findMagicIndexND(arr, beg, left);
        if (leftIndex >= 0) return leftIndex;

        int right = Math.max(index + 1, arr[index]);
        int rightIndex = findMagicIndexND(arr, right, end);
        return rightIndex;
    }

}
