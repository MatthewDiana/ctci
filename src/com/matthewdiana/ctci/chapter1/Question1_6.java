package com.matthewdiana.ctci.chapter1;

public class Question1_6 {

    public static void main(String[] args) {

        String[] inputArgs = {"aabcccccaaa", "aaaaaaa", "abcdef"};
        for (String s : inputArgs) {
            System.out.printf("%s - %s %s %s %s\n", s, stringCompress1(s), compressBad(s), compressS1(s), compressS2(s));
        }

    }

    // my first solution attempt
    private static String stringCompress1(String s) {

        if (s.isEmpty())
            return s;

        StringBuilder sb = new StringBuilder();
        char currChar = s.charAt(0);
        int currCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != currChar) {
                sb.append(Character.toString(currChar));
                sb.append(currCount);
                currChar = s.charAt(i);
                currCount = 1;
            } else {
                currCount++;
            }
        }

        sb.append(Character.toString(currChar) + currCount);

        String retStr = sb.toString();
        return retStr.length() >= s.length() ? s : retStr;
    }

    private static String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different than current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
    }

    private static String compressS1(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    private static String compressS2(String str) {
        /* Check final length and return input string if it would be longer. */
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    private static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different than current, increase the length. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
            }
        }
        return compressedLength;
    }

}
