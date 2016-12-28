package com.matthewdiana.ctci.chapter1;

import java.util.Arrays;

public class Question1_3 {

    public static void main(String[] args) {
        char[] inputArg = new char[] {
                'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '
        };
        char[] origArr = inputArg.clone();
        urlify1(origArr, 13);
        char[] anotherOrigArr = inputArg.clone();
        urlify2(anotherOrigArr, 13);
        char[] yetAnotherOrigArr = inputArg.clone();
        replaceSpaces(yetAnotherOrigArr, 13);
        System.out.printf("%s:\n\t%s\n\t%s\n\t%s\n", Arrays.toString(inputArg),
                Arrays.toString(origArr),
                Arrays.toString(anotherOrigArr),
                Arrays.toString(yetAnotherOrigArr));
    }

    // my first solution attempt
    public static void urlify1(char[] chArr, int trueLength) {

        for (int i = 0; i < trueLength; i++) {
            if (chArr[i] == ' ') {
                // push back everything after space
                for (int j = chArr.length-1; j > i+2; j--) {
                    chArr[j] = chArr[j-2];
                }
                chArr[i] = '%';
                chArr[i+1] = '2';
                chArr[i+2] = '0';
            }
        }
    }

    // my second attempt
    public static void urlify2(char[] chArr, int trueLength) {
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chArr[i] == ' ') spaces++;
        }

        int trueCounter = trueLength + (spaces * 2) - 1;
        for (int i = trueLength - 1; i >= 0; i--, trueCounter--) {
            if (chArr[i] == ' ' ) {
                chArr[trueCounter] = '0';
                chArr[trueCounter-1] = '2';
                chArr[trueCounter-2] = '%';
                trueCounter -= 2;
            } else {
                chArr[trueCounter] = chArr[i];
            }
        }
    }

    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0'; // End array
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
