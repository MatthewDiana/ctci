package com.matthewdiana.ctci.chapter4;

public class Question4_5 {

    public static void main(String[] args) {

        System.out.println(validateBT(createBT()));
        System.out.println(validateBT(createBST()));

    }

    public static boolean validateBT(TreeNode<Integer> root) {
        return validateBT(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBT(TreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        return validateBT(root.left, min, root.value - 1) && validateBT(root.right, root.value + 1, max);
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

    private static TreeNode<Integer> createBST() {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(10);
        root.left.right = new TreeNode<>(4);
        return root;
    }

}
