package com.matthewdiana.ctci.chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question1_8 {

    public static void main(String[] args) {

        int[][] someMatrix = { {1, 2, 3}, {2, 0}, {1, 1, 1, 0, 3} };
        printMatrix(someMatrix);
        printMatrix(markZeroRowsAndCols(someMatrix));
    }

    public static int[][] markZeroRowsAndCols(int[][] matrix) {

        Set<Integer> zeroCols = new HashSet<>();
        Set<Integer> zeroRows = new HashSet<>();

        int[][] newMatrix = matrix.clone();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroCols.add(j);
                    zeroRows.add(i);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroCols.contains(j) || zeroRows.contains(i)) {
                    newMatrix[i][j] = 0;
                }
            }
        }

        return newMatrix;


    }

    private static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
