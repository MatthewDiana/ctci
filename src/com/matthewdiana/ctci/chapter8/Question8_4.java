package com.matthewdiana.ctci.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question8_4 {

    public static void main(String[] args) {
        List<String> mySet = new ArrayList<>();
        mySet.add("chicken");
        mySet.add("nuggets");
        mySet.add("good");
        System.out.println(Arrays.toString(getPowerSet(mySet).toArray()));
    }

    public static List<List<String>> getPowerSet(List<String> set) {
        return getPowerSet(set, 0);
    }

    private static List<List<String>> getPowerSet(List<String> set, int index) {
        List<List<String>> powerSet;
        if (set.size() == index) {
            powerSet = new ArrayList<>();
            powerSet.add(new ArrayList<>());
        } else {
            powerSet = getPowerSet(set, index + 1);
            String item = set.get(index);
            List<List<String>> moreSubsets = new ArrayList<>();
            for (List<String> subset : powerSet) {
                List<String> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            powerSet.addAll(moreSubsets);
        }
        return powerSet;
    }

}
