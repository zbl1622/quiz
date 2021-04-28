package com.leetcode.quiz;

/**
 * 633. 平方数之和
 * <p>
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a2 + b2 = c 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 */
public class Problem633 {

    public static void main(String... args) {
        int c = 4;

        System.out.println(new Problem633().judgeSquareSum(c));
    }

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= (int) Math.sqrt(c); i++) {
            int b2 = c - i * i;
            int b = (int) Math.sqrt(b2);
            if (b * b == b2) {
                return true;
            }
        }
        return false;
    }
}