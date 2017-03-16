package com.matthewdiana.ctci.chapter4;

import java.util.*;

public class Question4_3 {

    public static void main(String[] args) {

        TreeNode<Integer> root = createBT();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> currLst = new ArrayList<>();
        Queue<TreeNode<Integer>> tmp = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode<Integer> n = q.poll();
            currLst.add(n.value);
            if (n.left != null) tmp.add(n.left);
            if (n.right != null) tmp.add(n.right);
            if (q.isEmpty()) {
                ll.add(currLst);
                q = tmp;
                tmp = new LinkedList<>();
                currLst = new ArrayList<>();
            }
        }
        System.out.println(Arrays.toString(ll.toArray()));
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

}
