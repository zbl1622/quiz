package com.leetcode.quiz;

import java.util.HashSet;

/**
 * 1361. 验证二叉树
 * <p>
 * 二叉树上有 n个节点，按从0到 n - 1编号，其中节点i的两个子节点分别是leftChild[i]和rightChild[i]。
 * <p>
 * 只有 所有 节点能够形成且 只 形成 一颗有效的二叉树时，返回true；否则返回 false。
 * <p>
 * 如果节点i没有左子节点，那么leftChild[i]就等于-1。右子节点也符合该规则。
 * <p>
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * 输出：false
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1361 {

    public static void main(String... args) {
//        int[] leftChild = {1, -1, 3, -1};
//        int[] rightChild = {2, -1, -1, -1};
//        int[] leftChild = {1,-1,3,-1};
//        int[] rightChild = {2,3,-1,-1};
//        int[] leftChild = {1,0};
//        int[] rightChild = {-1,-1};
//        int[] leftChild = {1, -1, -1, 4, -1, -1};
//        int[] rightChild = {2, -1, -1, 5, -1, -1};
//        int[] leftChild = {1, 0, 3, -1};
//        int[] rightChild = {-1, -1, -1, -1};
        int[] leftChild = {1, 2, 0, -1};
        int[] rightChild = {-1, -1, -1, -1};

        System.out.println(new Problem1361().validateBinaryTreeNodes(leftChild.length, leftChild, rightChild));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] count = new int[n];//记录每个节点入度
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                count[leftChild[i]] += 1;
                if (count[leftChild[i]] > 1) {//有节点入度大于1则必然不满足
                    return false;
                }
                if (leftChild[leftChild[i]] == i) {//有双向引用则不满足
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                count[rightChild[i]] += 1;
                if (count[rightChild[i]] > 1) {
                    return false;
                }
                if (rightChild[rightChild[i]] == i) {
                    return false;
                }
            }
        }
        int index = -1;
        for (int i = 0; i < n; i++) {//寻找入度为0的节点
            if (count[i] == 0) {
                if (index != -1) {
                    return false;//超过一个点入度为0，则必然不满足
                }
                index = i;
            }
        }
        if (index == -1) {//没有入度为0的节点，则必然不满足
            return false;
        }
        //长度大于1，且入度为0的节点不能没有子节点
        return leftChild[index] != -1 || rightChild[index] != -1 || n == 1;
    }
}