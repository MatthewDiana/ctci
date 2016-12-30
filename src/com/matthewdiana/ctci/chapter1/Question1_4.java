package com.matthewdiana.ctci.chapter1;

public class Question1_4 {

    public static void main(String[] args) {
        String[] inputArgs = {"Tact Coa", "chicken", "hello there", "ra ce car"};
        for (String s : inputArgs) {
            System.out.printf("%s - %b %b %b %b\n", s, hasPalinPermu1(s), isPermutationOfPalindromeS1(s),
                                                                          isPermutationOfPalindromeS2(s),
                                                                          isPermutationOfPalindromeS3(s));
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

    public static boolean isPermutationOfPalindromeS1(String phrase) {
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

    private static boolean isPermutationOfPalindromeS2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') -
                              Character.getNumericValue('a')];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static boolean isPermutationOfPalindromeS3(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    /* Create a bit vector for the string. For each letter with value i, toggle the
     * ith bit. */
    private static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /* Toggle the ith bit in the integer. */
    private static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    /* Check that exactly one bit is set by subtracting one from the integer and
     * ANDing it with the original integer. */
    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

}
