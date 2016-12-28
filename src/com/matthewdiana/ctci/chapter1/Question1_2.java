package com.matthewdiana.ctci.chapter1;

import java.util.Arrays;

public class Question1_2 {

    public static void main(String[] args) {
        String[] s1Inputs = {"chicken", "nuggets", "coding", "hello"};
        String[] s2Inputs = {"kenihcc", "gueats", "odincg", "ellah"};
        for (int i = 0; i < s1Inputs.length; i++)
            System.out.printf("%s,%s - %b %b %b %b\n", s1Inputs[i], s2Inputs[i],
                    permutation1(s1Inputs[i], s2Inputs[i]),
                    permutation2(s1Inputs[i], s2Inputs[i]),
                    permutationS1(s1Inputs[i], s2Inputs[i]),
                    permutationS2(s1Inputs[i], s2Inputs[i]));
    }

    public static boolean permutation1(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        return Arrays.equals(s1Arr, s2Arr);
    }

    public static boolean permutation2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] s1Counter = new int[256];
        int[] s2Counter = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            s1Counter[s1.charAt(i)]++;
            s2Counter[s2.charAt(i)]++;
        }

        return Arrays.equals(s1Counter, s2Counter);
    }

    public static String sortS1(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutationS1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sortS1(s).equals(sortS1(t));
    }

    public static boolean permutationS2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128]; // Assumption

        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

}
