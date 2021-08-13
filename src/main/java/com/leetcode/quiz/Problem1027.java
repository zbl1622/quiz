package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 1027. 最长等差数列
 * 给定一个整数数组A，返回 A中最长等差子序列的长度。
 * <p>
 * 回想一下，A的子序列是列表A[i_1], A[i_2], ..., A[i_k] 其中0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果B[i+1] - B[i](0 <= i < B.length - 1) 的值都相同，那么序列B是等差的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * <p>
 * 示例 3：
 * <p>
 * 输入：[20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1027 {

    public static void main(String... args) {
        int[] array = {9, 4, 7, 2, 10};
//        int[] array = {24, 13, 1, 100, 0, 94, 3, 0, 3};

        System.out.println(new Problem1027().longestArithSeqLength(array));
    }

    public int longestArithSeqLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];
        maps[0] = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int length = Math.max(maps[i].getOrDefault(diff, 0), maps[j].getOrDefault(diff, 0) + 1);
                maps[i].put(diff, length);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength + 1;
    }
}