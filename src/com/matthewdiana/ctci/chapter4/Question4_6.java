package com.matthewdiana.ctci.chapter4;

public class Question4_6 {

    public static void main(String[] args) {

        TreeNodeP<Integer> root = createBST();
        System.out.println(findNext(root.left.left));
        System.out.println(findNext(root.right));
        System.out.println(findNext(root));

    }

    public static int findNext(TreeNodeP<Integer> n) {

        if (n == null) return Integer.MIN_VALUE;

        if (n.right != null) {
            TreeNodeP curr = n.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return (int) curr.value;
        } else {
            TreeNodeP prev = n;
            TreeNodeP curr = n.parent;
            while (curr != null && curr.left != prev) {
                n = n.parent;
                curr = curr.parent;
            }
            return (int) curr.value;
        }
    }

    private static TreeNodeP<Integer> createBST() {
        TreeNodeP<Integer> root = new TreeNodeP<>(7);
        root.left = new TreeNodeP<>(5);
        root.right = new TreeNodeP<>(12);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new TreeNodeP<>(1);
        root.left.left.parent = root.left;
        root.right.left = new TreeNodeP<>(10);
        root.right.right = new TreeNodeP<>(13);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;
        return root;
    }

}

class TreeNodeP<T> {

    T value;
    TreeNodeP<T> left;
    TreeNodeP<T> right;
    TreeNodeP<T> parent;

    public TreeNodeP() { }

    public TreeNodeP(T value) {
        this.value = value;
    }

}