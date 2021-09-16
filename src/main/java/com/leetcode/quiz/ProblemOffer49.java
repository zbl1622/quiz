package com.leetcode.quiz;

/**
 * 剑指 Offer 49. 丑数
 * <p>
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1是丑数。
 * n不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProblemOffer49 {

    public static void main(String... args) {
        int n = 10;

        System.out.println(new ProblemOffer49().nthUglyNumber(n));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int i = 1;
        while (i < n) {
            int min;
            if (dp[p2] * 2 < dp[p3] * 3 && dp[p2] * 2 < dp[p5] * 5) {
                min = dp[p2] * 2;
                p2 += 1;
            } else if (dp[p3] * 3 < dp[p5] * 5) {
                min = dp[p3] * 3;
                p3 += 1;
            } else {
                min = dp[p5] * 5;
                p5 += 1;
            }
            if (min != dp[i - 1]) {
                dp[i] = min;
                i += 1;
            }
        }
        return dp[n - 1];
    }
}