package com.leetcode.quiz;

/**
 * 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem671 {

    public static void main(String... args) {
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

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null || root.right == null) {
            return -1;
        }
        int secondMinLeft = -1;
        int secondMinRight = -1;
        if (root.left.val == root.right.val) {
            secondMinLeft = findSecondMinimumValue(root.left);
            secondMinRight = findSecondMinimumValue(root.right);
        } else if (root.left.val == root.val) {
            secondMinLeft = findSecondMinimumValue(root.left);
            secondMinRight = root.right.val;
        } else {
            secondMinLeft = root.left.val;
            secondMinRight = findSecondMinimumValue(root.right);
        }
        if (secondMinLeft == -1) {
            return secondMinRight;
        } else {
            if (secondMinRight == -1) {
                return secondMinLeft;
            } else {
                return Math.min(secondMinLeft, secondMinRight);
            }
        }
    }
}