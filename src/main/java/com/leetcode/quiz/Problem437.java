package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 437. 路径总和 III
 * <p>
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * -109<= Node.val <= 109
 * -1000<= targetSum<= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem437 {

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

        System.out.println(new Problem437().pathSum(root, 22));
    }

    private int count;

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        find(hashMap, root, 0, targetSum);
        return count;
    }

    private void find(HashMap<Integer, Integer> hashMap, TreeNode node, int preSum, int targetSum) {
        if (node == null) {
            return;
        }
        node.val += preSum;
        int key = node.val - targetSum;
        count += hashMap.getOrDefault(key, 0);
        hashMap.put(node.val, hashMap.getOrDefault(node.val, 0) + 1);
        find(hashMap, node.left, node.val, targetSum);
        find(hashMap, node.right, node.val, targetSum);
        hashMap.put(node.val, hashMap.getOrDefault(node.val, 0) - 1);
    }
}