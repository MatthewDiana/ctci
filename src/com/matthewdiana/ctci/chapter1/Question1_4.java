package com.matthewdiana.ctci.chapter1;

public class Question1_4 {

    public static void main(String[] args) {
        String[] inputArgs = {"Tact Coa", "chicken", "hello there", "ra ce car"};
        for (String s : inputArgs) {
            System.out.printf("%s - %b %b\n", s, hasPalinPermu1(s), isPermutationOfPalindromeS(s));
        }
    }

    // my first solution attempt
    public static boolean hasPalinPermu1(String s) {
        int[] charCount = new int[256];
        String lowerS = s.toLowerCase();
        for (int i = 0; i < lowerS.length(); i++) {
            if (lowerS.charAt(i) != ' ') {
                charCount[lowerS.charAt(i)]++;
            }
        }
        int singlesCount = 0, trueLength = 0;
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] == 1) {
                singlesCount++;
            }
            trueLength += charCount[i];
        }

        return trueLength % 2 == 0 ? singlesCount == 0 : singlesCount == 1;

    }

    public static boolean isPermutationOfPalindromeS(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    /* Check that no more than one character has an odd count. */
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /* Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
     * This is case insentsitive. Non-letter characters map to -1 */
    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    /* Count how many times each character appears. */
    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

}
