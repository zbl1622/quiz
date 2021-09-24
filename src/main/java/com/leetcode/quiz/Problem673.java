package com.leetcode.quiz;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数
 * <p>
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意:给定的数组长度不超过 2000 并且结果一定是32位有符号整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem673 {

    public static void main(String... args) {
        int[] nums = {1, 3, 5, 4, 7};
//        int[] nums = {2, 2, 2, 2, 2};
//        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};

        System.out.println(new Problem673().findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        int[] m = new int[nums.length];
        int[] c = new int[nums.length];
        Arrays.fill(m, 1);
        c[0] = 1;
        int max = 1;
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            int s = 1;
            int tempMax = m[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (m[j] + 1 > tempMax) {
                        tempMax = m[j] + 1;
                        s = c[j];
                    } else if (m[j] + 1 == tempMax) {
                        s += c[j];
                    }
                }
            }
            m[i] = tempMax;
            c[i] = s;
            if (tempMax == max) {
                sum += s;
            } else if (tempMax > max) {
                max = tempMax;
                sum = s;
            }
        }
        return sum;
    }
}