package com.leetcode.quiz;

/**
 * 226. 翻转二叉树
 */
public class Problem226 {

    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        generateTree(root, 15, 1);
        System.out.println(new Problem226().invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static void generateTree(TreeNode node, int length, int n) {
        int value = n * 2;
        if (value <= length) {
            node.left = new TreeNode(value);
            generateTree(node.left, length, value);

            value += 1;
            if (value <= length) {
                node.right = new TreeNode(value);
                generateTree(node.right, length, value);
            }
        }

    }
}
