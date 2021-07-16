package com.leetcode.quiz;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProblemOffer53 {

    public static void main(String... args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;
        int[] nums = {1};
        int target = 1;

        System.out.println(new ProblemOffer53().search(nums, target));
    }

//    public int search(int[] nums, int target) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int left = 0;
//        int right = 0;
//
//        int start = 0;
//        int end = nums.length - 1;
//        while (start <= end) {
//            int index = (start + end) >> 1;
//            if (target > nums[index]) {
//                start += 1;
//                left = index;
//            } else {
//                end -= 1;
//            }
//        }
//
//        target += 1;
//        start = 0;
//        end = nums.length - 1;
//        while (start <= end) {
//            int index = (start + end) >> 1;
//            if (target > nums[index]) {
//                start += 1;
//                right = index;
//            } else {
//                end -= 1;
//            }
//        }
//        int s = right - left;
//        if (right == left && nums[left] == target - 1) {
//            s += 1;
//        }
//        return s;
//    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int left = 0;
        while (start <= end) {
            int index = (start + end) >> 1;
            if (target > nums[index]) {
                start += 1;
                left = index;
            } else {
                end -= 1;
            }
        }
        int s = 0;
        for (int i = left; i < nums.length; i++) {
            if (nums[i] == target) {
                s += 1;
            } else if (nums[i] > target) {
                break;
            }
        }
        return s;
    }
}