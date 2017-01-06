package com.matthewdiana.ctci.chapter1;

import java.util.Arrays;

public class Question1_7 {

    public static void main(String[] args) {
        int[][] inputArg = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] inputArgS = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.printf("Input: \n\t%s\n", Arrays.deepToString(inputArg));

        System.out.printf("MyOutput: \n\t%s\n", Arrays.deepToString(rotateMatrix1(inputArg)));
        rotateS(inputArgS);
        System.out.printf("Solution: \n\t%s\n", Arrays.deepToString(inputArgS));
    }

    // my naive solution.... O(n^2) space complexity
    public static int[][] rotateMatrix1(int[][] matrix) {

        int numLayers = matrix.length / 2;
        int newMatrix[][] = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[matrix.length - j - 1][i];
            }
        }
        return newMatrix;
    }

    public static boolean rotateS(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }
        return true;
    }

}
