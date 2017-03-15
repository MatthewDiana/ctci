package com.matthewdiana.ctci.chapter3;

import java.util.Stack;

public class Question3_4 {

    public static void main(String[] args) {
        MyQueue<Integer> myQ = new MyQueue<>();
        myQ.insert(5);
        myQ.insert(7);
        System.out.println(myQ.peek());
        myQ.poll();
        System.out.println(myQ.peek());
    }

}

class MyQueue<T> {

    private Stack<T> begin;
    private Stack<T> end;

    public MyQueue() {
        begin = new Stack<T>();
        end = new Stack<T>();
    }

    public void insert(T item) {
        begin.push(item);
    }

    public T poll() {
        shift();
        if (end.isEmpty()) {
            throw new Error();
        }
        return end.pop();
    }

    public T peek() {
        shift();
        if (end.isEmpty()) {
            throw new Error();
        }
        return end.peek();
    }

    public void shift() {
        while (!begin.isEmpty()) {
            end.push(begin.pop());
        }
    }

    public boolean isEmpty() {
        return begin.isEmpty() && end.isEmpty();
    }

}
