package com.leetcode.quiz;

/**
 * 162. 寻找峰值
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem162 {

    public static void main(String... args) {
//        int[] array = {3, 2, 1};
//        int[] array = {1, 2, 3, 1};
        int[] array = {1, 2, 1, 3, 5, 6, 4};

        System.out.println(new Problem162().findPeakElement(array));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int center = (left + right) / 2;
            boolean f = center == 0 ? nums[center] < nums[center + 1] : nums[center - 1] < nums[center];
            if (f) {
                left = center + 1;
            } else {
                right = center - 1;
            }
        }
        return left == 0 ? 0 : left - 1;
    }
}