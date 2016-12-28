package com.matthewdiana.ctci.chapter1;

public class Question1_1 {

    public static void main(String[] args) {
        String[] inputArgs = {"abd2d", "hello", "cheesecake", "fairy", "chicken"};
        for (String s : inputArgs) System.out.printf("%s - %b %b %b %b\n", s, allUnique1(s), allUnique2(s), allUniqueS1(s), allUniqueS2(s));
    }

    public static boolean allUnique1(String s) {
        boolean charMap[] = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (charMap[currChar]) {
                return false;
            }
            charMap[currChar] = true;
        }
        return true;
    }

    // no additional data structures allowed.... O(n^2) run time complexity
    public static boolean allUnique2(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean allUniqueS1(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++ ) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static boolean allUniqueS2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

}
