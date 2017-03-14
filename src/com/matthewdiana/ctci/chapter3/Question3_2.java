package com.matthewdiana.ctci.chapter3;

import java.util.Stack;

public class Question3_2 {

    public static void main(String[] args) {
        StackWithMin s1 = new StackWithMin();
        s1.push(5);
        s1.push(7);
        s1.push(6);
        System.out.println(s1.min());

        StackWithMin2 s2 = new StackWithMin2();
        s2.push(5);
        System.out.println(s2.min());
        s2.push(3);
        System.out.println(s2.min());
        s2.push(89);
        System.out.println(s2.min());
        s2.pop();
        System.out.println(s2.min());
    }
}

class StackWithMin2 extends Stack<Integer> {

    private Stack<Integer> minVals;

    public StackWithMin2() {
        this.minVals = new Stack<>();
    }

    public void push(int value) {
        if (value < min()) {
            minVals.push(value);
        }
        super.push(value);
    }

    public int min() {
        return minVals.isEmpty() ? Integer.MAX_VALUE : minVals.peek();
    }

    public Integer pop() {
        int val = isEmpty() ? Integer.MAX_VALUE : super.pop();
        if (val == min()) minVals.pop();
        return val;
    }

}

class StackWithMin extends Stack<NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        return isEmpty() ? Integer.MAX_VALUE : peek().min;
    }
}

class NodeWithMin {
    public int value;
    public int min;
    public NodeWithMin(int v, int min) {
        this.value = v;
        this.min = min;
    }
}
