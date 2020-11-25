package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class Problem15 {

    public static void main(String... args) {
        int[] array = {-1, 0, 1, 2, -1, -4};

        System.out.println(JSON.toJSONString(new Problem15().threeSum(array)));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        return null;
    }
}