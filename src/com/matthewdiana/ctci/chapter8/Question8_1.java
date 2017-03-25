package com.matthewdiana.ctci.chapter8;

import java.util.Arrays;

public class Question8_1 {

    public static void main(String[] args) {

        System.out.println(numWays(2));
        System.out.println(numWays(3));
        System.out.println(numWays(10));
        System.out.println(numWays(37));
    }

    public static int numWays(int n) {
        int[] memoTable = new int[n + 1];
        Arrays.fill(memoTable, -1);
        return numWays(n, memoTable);
    }

    private static int numWays(int n, int[] memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        if (memo[n] == -1) {
            memo[n] = numWays(n - 1, memo) + numWays(n - 2, memo) + numWays(n - 3, memo);
        }
        return memo[n];
    }

}
