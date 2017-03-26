package com.matthewdiana.ctci.chapter8;

import java.util.*;

public class Question8_2 {

    public static void main(String[] args) {

        boolean grid[][] = new boolean[10][10];
        for (boolean[] row : grid) {
            Arrays.fill(row, true);
        }
        // set up off limit cells in the grid (randomly picked)
        grid[2][5] = false;
        grid[7][7] = false;
        grid[5][8] = false;
        grid[3][0] = false;

        System.out.println(Arrays.toString(getValidPath(grid).toArray()));
        System.out.println(Arrays.toString(getValidPathMemo(grid).toArray()));

        // try blocking off the exit, should get null
        grid[9][8] = false;
        grid[8][9] = false;

        System.out.println(getValidPath(grid) == null ? "no valid path found" : "this shouldn't happen");
        System.out.println(getValidPathMemo(grid) == null ? "no valid path found" : "this shouldn't happen");


    }

    public static List<String> getValidPath(boolean[][] grid) {
        return getValidPath(grid, new ArrayList<>(), 0, 0);
    }

    public static List<String> getValidPathMemo(boolean[][] grid) {
        return getValidPathMemo(grid, new ArrayList<>(), 0, 0, new HashSet<>());
    }

    private static List<String> getValidPath(boolean[][] grid, List<String> path, int row, int col) {
        path.add(pairToStr(row, col));

        // we have reached the end... return this path.
        if (row == grid.length-1 && col == grid[row].length-1) {
            return path;
        }

        if (row + 1 < grid.length && grid[row+1][col]) return getValidPath(grid, path, row + 1, col);
        if (col + 1 < grid[row].length && grid[row][col+1]) return getValidPath(grid, path, row, col + 1);

        // no more possibilities, return null
        return null;

    }

    private static List<String> getValidPathMemo(boolean[][] grid, List<String> path, int row, int col, Set<String> failed) {
        path.add(pairToStr(row, col));

        // we have reached the end... return this path.
        if (row == grid.length-1 && col == grid[row].length-1) {
            return path;
        }

        if (!failed.contains(pairToStr(row, col))) {
            if (row + 1 < grid.length && grid[row+1][col]) return getValidPath(grid, path, row + 1, col);
            if (col + 1 < grid[row].length && grid[row][col+1]) return getValidPath(grid, path, row, col + 1);
        }

        failed.add(pairToStr(row, col));

        // no more possibilities, return null
        return null;
    }

    private static String pairToStr(int row, int col) {
        return "("+row+","+col+")";
    }

}
