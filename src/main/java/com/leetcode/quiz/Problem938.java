package com.leetcode.quiz;

/**
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 */
public class Problem938 {

    public static void main(String... args) {
        Integer[] array = new Integer[]{10, 5, 15, 3, 7, null, 18};
        TreeNode root = new TreeNode(array[0]);
        generateTree(array, root, 0);
        int low = 7, high = 15;

        System.out.println(new Problem938().rangeSumBST(root, low, high));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int r = 0;
        if (root.val > low && root.left != null) {
            r += rangeSumBST(root.left, low, high);
        }
        if (root.val < high && root.right != null) {
            r += rangeSumBST(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            r += root.val;
        }
        return r;
    }

    private static void generateTree(Integer[] array, TreeNode root, int index) {
        int i = index * 2 + 1;
        if (i < array.length && array[i] != null) {
            TreeNode left = new TreeNode(array[i]);
            root.left = left;
            generateTree(array, left, i);
        }
        i += 1;
        if (i < array.length && array[i] != null) {
            TreeNode right = new TreeNode(array[i]);
            root.right = right;
            generateTree(array, right, i);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}