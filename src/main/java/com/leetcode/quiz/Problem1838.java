package com.leetcode.quiz;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * <p>
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 * }
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 * }
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1838 {

    public static void main(String... args) {
        int[] nums = {1, 2, 4};
        int k = 5;
//        int[] nums = {1,4,8,13};
//        int k = 5;
//        int[] nums = {3, 9, 6};
//        int k = 2;
//        int[] nums = {9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966};
//        int k = 3056;

        System.out.println(new Problem1838().maxFrequency(nums, k));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = start;
        int max = 1;
        int s = k;
        while (end < nums.length - 1) {
            int diff = (nums[end + 1] - nums[end]) * (end - start + 1);
            if (diff <= s) {
                s -= diff;
                end += 1;
            } else if (start == end) {
                start += 1;
                end += 1;
            } else {
                s += nums[end] - nums[start];
                start += 1;
            }
            int f = end - start + 1;
            if (f > max) {
                max = f;
            }
        }
        return max;
    }
}