package com.leetcode.quiz;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class Problem34 {

    public static void main(String... args) {
//        int[] array = new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10};
//        int target = 8;
        int[] array = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
//        int[] array = new int[]{};
//        int target = 0;
//        int[] array = new int[]{2, 2};
//        int target = 2;
        System.out.println(Arrays.toString(new Problem34().searchRange(array, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left1 = 0, right1 = nums.length - 1;
        int left2 = 0, right2 = nums.length - 1;
        int index = 0;
        while (left1 < right1 - 1) {
            index = (left1 + right1) / 2;
            if (nums[index] >= target) {
                right1 = index;
            } else {
                left1 = index;
            }
        }
        while (left2 < right2 - 1) {
            index = (left2 + right2) / 2;
            if (nums[index] > target) {
                right2 = index;
            } else {
                left2 = index;
            }
        }
        int left = -1, right = -1;
        if (nums[left1] == target) {
            left = left1;
        } else if (nums[right1] == target) {
            left = right1;
        }
        if (nums[right2] == target) {
            right = right2;
        } else if (nums[left2] == target) {
            right = left2;
        }
        return new int[]{left, right};
    }
}