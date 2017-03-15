package com.matthewdiana.ctci.chapter3;

import java.util.Stack;

public class Question3_3 {

    public static void main(String[] args) {
        SetOfStacks<Integer> myStack = new SetOfStacks<>(2);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
    }

}

class SetOfStacks<T> {

    private int maxSize;
    private Stack<Stack<T>> bigStack;

    public SetOfStacks(int maxSize) {
        this.maxSize = maxSize;
        bigStack = new Stack<>();
    }

    public void push(T val) {
        if (bigStack.isEmpty() || bigStack.peek().size() == maxSize) {
            bigStack.push(new Stack<T>());
        }
        bigStack.peek().push(val);
    }

    public T pop() throws Error {
        if (bigStack.isEmpty())
            throw new Error();
        T val = bigStack.peek().pop();
        if (bigStack.peek().isEmpty()) bigStack.pop();
        return val;
    }

    public T peek() throws Error {
        if (bigStack.isEmpty())
            throw new Error();
        return bigStack.peek().peek();
    }

}
