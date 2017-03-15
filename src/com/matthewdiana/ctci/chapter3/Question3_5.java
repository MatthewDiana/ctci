package com.matthewdiana.ctci.chapter3;

import java.util.Comparator;
import java.util.Stack;

public class Question3_5 {

    public static void main(String[] args) {

        SortableStack<Integer> myStack = new SortableStack<>();
        myStack.push(10);
        myStack.push(13);
        myStack.push(11);
        myStack.push(4);
        myStack.push(22);
        myStack.print();
        myStack.sort();
        myStack.print();


    }

}

class SortableStack<T extends Comparable<T>> extends Stack<T> {

    public void sort() {
        SortableStack<T> tmpStack = new SortableStack<>();
        while (!isEmpty()) {
            if (tmpStack.isEmpty() || tmpStack.peek().compareTo(peek()) >= 0) {
                tmpStack.push(pop());
            } else {
                T tmp = pop();
                while (!tmpStack.isEmpty()) {
                    push(tmpStack.pop());
                }
                tmpStack.push(tmp);
            }
        }
        while (!tmpStack.isEmpty()) push(tmpStack.pop());
    }

    public void print() {
        for (T ele : this) {
            System.out.print(ele + " -> ");
        }
        System.out.println();
    }

}
