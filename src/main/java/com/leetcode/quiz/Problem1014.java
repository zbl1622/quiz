package com.leetcode.quiz;

import java.util.Arrays;

/**
 * 1014. 最佳观光组合
 * <p>
 * 给你一个正整数数组 values，其中 values[i]表示第 i 个观光景点的评分，并且两个景点i 和j之间的 距离 为j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * 示例 2：
 * <p>
 * 输入：values = [1,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= values.length <= 5 * 10^4
 * 1 <= values[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1014 {

    public static void main(String... args) {
//        int[] array = {8, 1, 5, 2, 6};
        int[] array = {3, 7, 2, 3};

        System.out.println(new Problem1014().maxScoreSightseeingPair(array));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max = 0;
        int max_i = values[0];
        for (int i = 1; i < n; i++) {
            int value = values[i] - i + max_i;
            if (value > max) {
                max = value;
            }
            if (values[i] + i > max_i) {
                max_i = values[i] + i;
            }
        }
        return max;
    }
}