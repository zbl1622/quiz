package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr中 所有奇数长度子数组的和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1588 {

    public static void main(String... args) {
        int[] array = {1,2};

        System.out.println(new Problem1588().sumOddLengthSubarrays(array));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int s = 0;
        int[][] dp = new int[arr.length][arr.length];
        dp[0][0] = arr[0];
        s += dp[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = arr[i];
            s += dp[i][0];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + arr[i];
                if (j % 2 == 0) {
                    s += dp[i][j];
                }
            }
        }
        return s;
    }
}