package com.leetcode.quiz;

/**
 * 1379. 找出克隆二叉树中的相同节点
 * <p>
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original中的目标节点target。
 * <p>
 * 其中，克隆树 cloned是原始树 original的一个 副本 。
 * <p>
 * 请找出在树cloned中，与target相同的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你 不能 对两棵二叉树，以及 target节点进行更改。
 * 只能 返回对克隆树cloned中已有的节点的引用。
 * 进阶：如果树中允许出现值相同的节点，你将如何解答？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: tree = [7,4,3,null,null,6,19], target = 3
 * 输出: 3
 * 解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其他示例类似）。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: tree = [7], target =  7
 * 输出: 7
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * <p>
 * 输入: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * 输出: 4
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * <p>
 * 输入: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
 * 输出: 5
 * <p>
 * 示例 5:
 * <p>
 * <p>
 * <p>
 * 输入: tree = [1,2,null,3], target = 2
 * 输出: 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量范围为[1, 10^4]。
 * 同一棵树中，没有值相同的节点。
 * target节点是树original中的一个节点，并且不会是null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1379 {

    private static Integer[] tree = new Integer[]{8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1};
    private static int index = 0;

    public static void main(String... args) {
        index = 0;
        TreeNode original = generateTree();
        index = 0;
        TreeNode cloned = generateTree();
        TreeNode target = original.right.right.right;
        System.out.println(new Problem1379().getTargetCopy(original, cloned, target).val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int path = 0;
    int deep = 0;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        find(target, original, 0, 0);
        TreeNode node = cloned;
        while (deep > 0) {
            node = ((1 << (deep - 1)) & path) > 0 ? node.right : node.left;
            deep -= 1;
        }
        return node;
    }

    public void find(TreeNode target, TreeNode node, int p, int d) {
        if (node == null) {
            return;
        }
        if (node == target) {
            path = p;
            deep = d;
            return;
        }
        find(target, node.left, p << 1, d + 1);
        find(target, node.right, (p << 1) + 1, d + 1);
    }

    public static TreeNode generateTree() {
        if (index >= tree.length) {
            return null;
        }
        if (tree[index] == null) {
            index += 1;
            return null;
        }
        TreeNode node = new TreeNode(tree[index]);
        index += 1;
        node.left = generateTree();
        node.right = generateTree();
        return node;
    }
}