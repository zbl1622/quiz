package com.leetcode.quiz;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Problem105 {

    public static void main(String... args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
//        int[] preorder = {3, 1, 2, 4};
//        int[] inorder = {1, 2, 3, 4};
//        int[] preorder = {1, 2};
//        int[] inorder = {1, 2};
//        int[] preorder = {1, 2, 3};
//        int[] inorder = {2, 3, 1};

        System.out.println(new Problem105().buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end) {
        TreeNode root = new TreeNode(preorder[p_start]);
        int index = findValueIndex(inorder, root.val, i_start, i_end);
        if (index < 0) {
            return null;
        }
        int leftLength = index - i_start;
        int rightLength = i_end - index;
        if (leftLength > 0) {
            root.left = buildTree(preorder, inorder, p_start + 1, p_start + leftLength, i_start, index - 1);
        }
        if (rightLength > 0) {
            root.right = buildTree(preorder, inorder, p_end - rightLength + 1, p_end, index + 1, i_end);
        }
        return root;
    }

    public int findValueIndex(int[] array, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}