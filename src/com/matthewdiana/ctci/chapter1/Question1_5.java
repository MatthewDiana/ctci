package com.matthewdiana.ctci.chapter1;

public class Question1_5 {

    public static void main(String[] args) {

        System.out.println(isOneAway("hello", "hllo"));
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bae"));

    }

    private static boolean isOneAway(String s1, String s2) {

        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        if (s1.length() == s2.length()) {
            return checkOneReplace(s1, s2);
        } else if (s1.length() > s2.length()) {
            return checkOneInsert(s2, s1);
        } else {
            return checkOneInsert(s1, s2);
        }

    }

    private static boolean checkOneReplace(String s1, String s2) {
        boolean replaceMade = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (replaceMade) {
                    return false;
                } else {
                    replaceMade = true;
                }
            }
        }
        return true;
    }

    private static boolean checkOneInsert(String s1, String s2) {
        String longerStr = s1.length() > s2.length() ? s1 : s2;
        String shorterStr = s1.length() > s2.length() ? s2 : s1;

        int longerInd = 0, shorterInd = 0;
        boolean insertMade = false;
        while (longerInd < longerStr.length() && shorterInd < shorterStr.length()) {
            if (shorterStr.charAt(shorterInd) != longerStr.charAt(longerInd)) {
                if (insertMade) {
                    return false;
                } else {
                    insertMade = true;
                    longerInd++;
                }
            }
            longerInd++;
            shorterInd++;
        }
        return true;
    }

}
