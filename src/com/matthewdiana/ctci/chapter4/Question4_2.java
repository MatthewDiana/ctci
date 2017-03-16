package com.matthewdiana.ctci.chapter4;

public class Question4_2 {

    public static void main(String[] args) {

        int[] arr = {2, 5, 6, 7, 8, 9, 13, 15, 22};
        BST<Integer> bst = formMinimalTree(arr);
        System.out.println(bst.root.value);
        System.out.println(bst.root.left.value);
        System.out.println(bst.root.left.left.value);
        System.out.println(bst.root.right.value);

    }

    public static BST<Integer> formMinimalTree(int[] arr) {
        BST<Integer> bst = new BST<>();
        bst.root = formMinimalTree(arr, 0, arr.length - 1);
        return bst;
    }

    private static TreeNode<Integer> formMinimalTree(int[] arr, int beg, int end) {

        if (beg > end) {
            return null;
        }

        TreeNode<Integer> n = new TreeNode<>();
        int mid = (beg+end) / 2;
        int val = arr[mid];
        n.value = val;
        n.left = formMinimalTree(arr, beg, mid - 1);
        n.right = formMinimalTree(arr, mid + 1, end);
        return n;
    }

}

class BST<T> {
    TreeNode<T> root;
}

class TreeNode<T> {

    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() { }

    public TreeNode(T value) {
        this.value = value;
    }

}
