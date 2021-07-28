package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值0 <= node.val <= 500。
 * 目标结点target是树上的结点。
 * 0 <= K <= 1000.
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem863 {

    public static void main(String... args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode target = root.left;
        int k = 2;

        System.out.println(JSON.toJSONString(new Problem863().distanceK(root, target, k)));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        int[] result = findTarget(root, target, 0, 0);
        int targetPath = result[0];
        int targetDeep = result[1];
        findDistanceK(list, root, target, 0, 0, targetPath, targetDeep, k);
        return list;
    }

    public int[] findTarget(TreeNode root, TreeNode target, int path, int deep) {
        if (root == target) {
            return new int[]{path, deep};
        } else if (root != null) {
            int[] r = findTarget(root.left, target, path << 1, deep + 1);
            if (r != null) {
                return r;
            } else {
                return findTarget(root.right, target, (path << 1) | 1, deep + 1);
            }
        } else {
            return null;
        }
    }

    public void findDistanceK(List<Integer> list, TreeNode root, TreeNode target, int path, int deep, int targetPath, int targetDeep, int k) {
        if (root == null) {
            return;
        }
        if (root == target) {
            findDistanceK(list, root, 0, 0, k);
        } else {
            if (deep + k == targetDeep) {
                list.add(root.val);
            }
            int r = (targetPath >> (targetDeep - deep - 1)) ^ (path << 1);
            if (r == 0) {
                findDistanceK(list, root.left, target, path << 1, deep + 1, targetPath, targetDeep, k);
                findDistanceK(list, root.right, 1, targetDeep - deep, k);
            } else {
                findDistanceK(list, root.left, 1, targetDeep - deep, k);
                findDistanceK(list, root.right, target, (path << 1) | 1, deep + 1, targetPath, targetDeep, k);
            }
        }
    }

    public void findDistanceK(List<Integer> list, TreeNode root, int deep, int rootTargetDistance, int k) {
        if (root == null) {
            return;
        }
        if (k == deep + rootTargetDistance) {
            list.add(root.val);
        } else {
            findDistanceK(list, root.left, deep + 1, rootTargetDistance, k);
            findDistanceK(list, root.right, deep + 1, rootTargetDistance, k);
        }
    }
}