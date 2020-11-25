package com.leetcode.quiz;

/**
 * 222. 完全二叉树的节点个数
 */
public class Problem222 {

    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        generateTree(root, 65533, 1);
        System.out.println(new Problem222().countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        TreeNode node = root;
        while (node != null) {
            depth += 1;
            node = node.left;
        }
        int left = 1 << depth - 1;
        int right = (1 << depth) - 1;
        int index = 0;
        while (left != right && left + 1 != right) {
            index = (left + right) / 2;
            if (isEmpty(root, index, depth)) {
                right = index;
            } else {
                left = index;
            }
        }
        if (!isEmpty(root, right, depth)) {
            return right;
        } else {
            return left;
        }
    }

    public boolean isEmpty(TreeNode root, int index, int depth) {
        TreeNode node = root;
        int mask = 1 << depth - 1;
        for (int i = 1; i < depth; i++) {
            mask >>= 1;
            if ((index & mask) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node == null;
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
