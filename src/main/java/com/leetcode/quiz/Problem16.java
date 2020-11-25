package com.leetcode.quiz;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class Problem16 {

    public static void main(String... args) {
        int[] array = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(new Problem16().threeSumClosest(array, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int minDifference = Integer.MAX_VALUE;
        int resultSum = 0;
        int sum, difference;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    difference = Math.abs(sum - target);
                    if (difference == 0) {
                        return target;
                    } else if (difference < minDifference) {
                        minDifference = difference;
                        resultSum = sum;
                    }
                }
            }
        }
        return resultSum;
    }
}