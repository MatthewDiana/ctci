package com.matthewdiana.ctci.chapter8;

public class Question8_5 {

    public static void main(String[] args) {

        System.out.println(rMultiply(5, 3));

    }

    public static int rMultiply(int a, int b) {
        return rMultiplyHelp(Math.min(a, b), Math.max(a, b));
    }

    private static int rMultiplyHelp(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        int s = smaller >> 1;
        int halfProd = rMultiplyHelp(s, bigger);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }



}
