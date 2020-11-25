package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Problem283 {

    public static void main(String... args) {
        int[] array = {0, 1, 0, 3, 12};
        new Problem283().moveZeroes(array);
        System.out.println(JSON.toJSONString(array));
    }

    public void moveZeroes(int[] nums) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex] = nums[i];
                writeIndex += 1;
            }
        }
        Arrays.fill(nums, writeIndex, nums.length, 0);
    }
}