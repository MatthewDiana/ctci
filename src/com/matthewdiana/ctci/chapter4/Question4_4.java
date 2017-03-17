package com.matthewdiana.ctci.chapter4;

public class Question4_4 {

    public static void main(String[] args) {

        TreeNode<Integer> root = createBT();
        System.out.println(isBalanced(root));

    }

    private static int checkHeight(TreeNode<Integer> root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private static boolean isBalanced(TreeNode<Integer> root) {
        return checkHeight(root) != Integer.MIN_VALUE;
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
