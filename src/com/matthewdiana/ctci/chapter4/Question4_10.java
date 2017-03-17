package com.matthewdiana.ctci.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class Question4_10 {

    public static void main(String[] args) {

        TreeNode<Integer> t = createBT();
        System.out.println(isSubtreeOf(t, createSubBT()));
        System.out.println(isSubtreeOf(t, createSubBT2()));
        System.out.println(isSubtreeOf(t, createSubBT3()));
        System.out.println(isSubtreeOf(t, createSubBT4()));

    }

    public static boolean isSubtreeOf(TreeNode<Integer> t1, TreeNode<Integer> t2) {

        if (t1 == null || t2 == null) return false;

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(t1);
        while (!q.isEmpty()) {
            TreeNode<Integer> curr = q.poll();
            if (isSameTree(curr, t2)) return true;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        return false;
    }

    private static boolean isSameTree(TreeNode<Integer> t1, TreeNode<Integer> t2) {

        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }

        Queue<TreeNode<Integer>> t1q = new LinkedList<>();
        Queue<TreeNode<Integer>> t2q = new LinkedList<>();
        t1q.add(t1);
        t2q.add(t2);

        while (!t1q.isEmpty() && !t2q.isEmpty()) {
            TreeNode<Integer> n1 = t1q.poll();
            TreeNode<Integer> n2 = t2q.poll();
            if (n1.value != n2.value) {
                return false;
            }
            if (n1.left != null) t1q.add(n1.left);
            if (n1.right != null) t1q.add(n1.right);
            if (n2.left != null) t2q.add(n2.left);
            if (n2.right != null) t2q.add(n2.right);
        }

        return t1q.isEmpty() && t2q.isEmpty();

    }

    private static TreeNode<Integer> createBT() {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(2);
        root.right.left = new TreeNode<>(25);
        root.left.left.left = new TreeNode<>(22);
        root.left.left.left.left = new TreeNode<>(2);
        root.left.left.left.right = new TreeNode<>(13);
        return root;
    }

    private static TreeNode<Integer> createSubBT() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(25);
        return root;
    }

    private static TreeNode<Integer> createSubBT2() {
        TreeNode<Integer> root = new TreeNode(13);
        return root;
    }

    private static TreeNode<Integer> createSubBT3() {
        TreeNode<Integer> root = new TreeNode(13);
        root.left = new TreeNode(3);
        return root;
    }

    private static TreeNode<Integer> createSubBT4() {
        TreeNode<Integer> root = new TreeNode(5);
        root.left = new TreeNode<>(3);
        return root;
    }

}
