package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class Problem103 {

    public static void main(String... args) {
        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = new TreeNode(array[0]);
        generateTree(array, root, 0);
        System.out.println(JSON.toJSONString(new Problem103().zigzagLevelOrder(root)));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        travel(lists, root, 0);
        return lists;
    }

    public void travel(List<List<Integer>> lists, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int flag = level % 2;
        LinkedList<Integer> list = null;
        if (level < lists.size()) {
            list = (LinkedList<Integer>) lists.get(level);
        } else {
            list = new LinkedList<>();
            lists.add(list);
        }
        if (flag == 0) {
            list.addLast(root.val);
        } else {
            list.addFirst(root.val);
        }
        travel(lists, root.left, level + 1);
        travel(lists, root.right, level + 1);
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