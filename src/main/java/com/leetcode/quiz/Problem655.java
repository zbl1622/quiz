package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 655. 输出二叉树
 * <p>
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * <p>
 * 行数m应当等于给定二叉树的高度。
 * 列数n应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 * <p>
 * 输入:
 * 1
 * /
 * 2
 * 输出:
 * [["", "1", ""],
 * ["2", "", ""]]
 * 示例 2:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 * 示例 3:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem655 {

    public static void main(String... args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(-2);
//        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(1);
//        root.right = new TreeNode(-3);
//        root.right.right = new TreeNode(11);
//
//        System.out.println(new Problem437().pathSum(root, 8));

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(JSON.toJSONString(new Problem655().printTree(root)));
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        measureDeep(root, 1);
        int width = (1 << maxDeep) - 1;
        for (int i = 0; i < maxDeep; i++) {
            List<String> layer = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                layer.add("");
            }
            list.add(layer);
        }
        fill(list, root, 1, 1, width);
        return list;
    }

    private int maxDeep;

    public void measureDeep(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep > maxDeep) {
            maxDeep = deep;
        }
        measureDeep(root.left, deep + 1);
        measureDeep(root.right, deep + 1);
    }

    private void fill(List<List<String>> list, TreeNode node, int deep, int path, int width) {
        if (node == null) {
            return;
        }
        int cell = width / 2;
        int index = path - (1 << (deep - 1));
        list.get(deep - 1).set(index * (width + 1) + cell, String.valueOf(node.val));
        fill(list, node.left, deep + 1, path << 1, cell);
        fill(list, node.right, deep + 1, (path << 1) + 1, cell);
    }
}