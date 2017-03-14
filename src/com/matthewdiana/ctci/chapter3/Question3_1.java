package com.matthewdiana.ctci.chapter3;

/*
    One method of using a single array to implement three stacks is to separate the array into 3
    static subsections. The downside of this is that each stack would have a maximum size of
    arr_len / 3 (no dynamic growth of stacks to use the space allocated to the other stacks). This
    could be another approach to take with this problem..... but it is a lot of work.
 */

public class Question3_1 {

    private static final int NUMBER_OF_STACKS = 3;

    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public Question3_1(int size) {
        this.stackCapacity = size;
        values = new int[size * NUMBER_OF_STACKS];
        sizes = new int[NUMBER_OF_STACKS];
    }

    /* Push value onto stack. */
    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)) throw new Exception();

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) throw new Exception();

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) throws Exception{
        if (isEmpty(stackNum)) throw new Exception();
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

}
