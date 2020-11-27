package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 */
public class Problem228 {

    public static void main(String... args) {
        int[] array = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(JSON.toJSONString(new Problem228().summaryRanges(array)));
    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        } else if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int lastNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (nums[i - 1] == lastNumber) {
                    list.add(String.valueOf(lastNumber));
                } else {
                    list.add(lastNumber + "->" + nums[i - 1]);
                }
                lastNumber = nums[i];
            }
        }
        if (nums[nums.length - 1] == lastNumber) {
            list.add(String.valueOf(lastNumber));
        } else {
            list.add(lastNumber + "->" + nums[nums.length - 1]);
        }
        return list;
    }
}
