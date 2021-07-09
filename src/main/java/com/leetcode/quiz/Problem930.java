package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem930 {

    public static void main(String... args) {
//        int[] array = {0, 0, 0, 0, 0};
//        int goal = 0;
//        int[] array = {1, 0, 1, 0, 1};
//        int goal = 2;
        int[] array = {0, 1, 1, 1, 1};
        int goal = 3;

        System.out.println(new Problem930().numSubarraysWithSum(array, goal));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int s = 0;
        int n = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            n += hashMap.getOrDefault(s - goal, 0);
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
            if (s == goal) {
                n += 1;
            }
        }
        return n;
    }
}