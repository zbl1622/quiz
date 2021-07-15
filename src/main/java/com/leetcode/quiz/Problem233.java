package com.leetcode.quiz;

/**
 * 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：6
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 2 * 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem233 {

    public static void main(String... args) {

        System.out.println(new Problem233().countDigitOne(1120));
    }

    public int countDigitOne(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            int count = 0;
            while (x > 0) {
                int r = x % 10;
                if (r == 1) {
                    count += 1;
                }
                x = (x - r) / 10;
            }
            s += count;
        }
        return s;
    }
}