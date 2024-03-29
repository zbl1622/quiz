package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 446. 等差数列划分 II - 子序列
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * <p>
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * <p>
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * <p>
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem446 {

    public static void main(String... args) {
//        int[] array = {2, 4, 6, 8, 10};
//        int[] array = {7, 7, 7, 7, 7};
        int[] array = {1, 2, 3, 4, 5, 6};

        System.out.println(new Problem446().numberOfArithmeticSlices(array));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        HashMap<Long, Integer>[] mapArray = new HashMap[nums.length];
        mapArray[0] = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            mapArray[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                mapArray[i].put(diff, mapArray[i].getOrDefault(diff, 0) + mapArray[j].getOrDefault(diff, 0) + 1);
            }
        }
        int s = 0;
        for (HashMap<Long, Integer> hashMap : mapArray) {
            for (int count : hashMap.values()) {
                s += count;
            }
        }
        int n = nums.length;
        return s - (n - 1) * n / 2;
    }
}