package com.matthewdiana.ctci.chapter4;

public class Question4_8 {

    public static void main(String[] args) {

        TreeNodeP<Integer> root = createBST();
        System.out.println(findCommonAncestor(root.left.left, root.right).value);
        System.out.println(findCommonAncestor(root.right.left, root.right).value);

    }

    private static TreeNodeP<Integer> findCommonAncestor(TreeNodeP<Integer> n1, TreeNodeP<Integer> n2) {

        TreeNodeP<Integer> tmpN1 = n1, tmpN2 = n2;
        int n1d = getDepth(tmpN1), n2d = getDepth(tmpN2);
        int delta = Math.abs(n1d - n2d);
        if (n1d > n2d) {
            while (delta > 0) {
                tmpN1 = tmpN1.parent;
                delta--;
            }
        } else {
            while (delta > 0) {
                tmpN2 = tmpN2.parent;
                delta--;
            }
        }

        while (tmpN1 != null && tmpN2 != null) {
            if (tmpN1 == tmpN2) return tmpN1;
            tmpN1 = tmpN1.parent;
            tmpN2 = tmpN2.parent;
        }

        return tmpN1 != null ? tmpN1 : tmpN2;

    }

    private static int getDepth(TreeNodeP<Integer> node) {
        int depth = 1;
        TreeNodeP<Integer> n = node;
        while (n != null) {
            n = n.parent;
            depth++;
        }
        return depth;
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
