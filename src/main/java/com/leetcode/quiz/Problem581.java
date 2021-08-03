package com.leetcode.quiz;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^4
 * -105 <= nums[i] <= 10^5
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem581 {

    public static void main(String... args) {
        int[] array = {2, 6, 4, 8, 10, 9, 15};
//        int[] array = {1, 2, 3, 4};

        System.out.println(new Problem581().findUnsortedSubarray(array));
    }

    public int findUnsortedSubarray(int[] nums) {
        int right = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }
        int left = nums.length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }
        return (right <= left) ? 0 : right - left + 1;
    }

//    /**
//     * 笨办法，先排序后找不同
//     */
//    public int findUnsortedSubarray(int[] nums) {
//        int[] array = new int[nums.length];
//        System.arraycopy(nums, 0, array, 0, nums.length);
//        Arrays.sort(array);
//        int start = 0, end = nums.length - 1;
//        for (int i = 0; i < nums.length; i++) {
//            start = i;
//            if (nums[i] != array[i]) {
//                break;
//            }
//        }
//        for (int i = nums.length - 1; i > start; i--) {
//            end = i;
//            if (nums[i] != array[i]) {
//                break;
//            }
//        }
//        return end - start + ((end == start) ? 0 : 1);
//    }
}