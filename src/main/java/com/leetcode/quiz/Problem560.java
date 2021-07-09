package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数k的范围是[-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem560 {

    public static void main(String... args) {
//        int[] array = {0, 0, 0, 0, 0};
//        int k = 0;
//        int[] array = {1, 0, 1, 0, 1};
//        int k = 2;
        int[] array = {1, 1, 1};
        int k = 2;

        System.out.println(new Problem560().subarraySum(array, k));
    }

    public int subarraySum(int[] nums, int k) {
        int s = 0;
        int n = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            n += hashMap.getOrDefault(s - k, 0);
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
            if (s == k) {
                n += 1;
            }
        }
        return n;
    }
}