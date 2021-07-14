package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 1818. 绝对差值和
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <p>
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * <p>
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * <p>
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 10^9 + 7 取余 后返回。
 * <p>
 * |x| 定义为：
 * <p>
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 10^5
 * 1 <= nums1[i], nums2[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1818 {

    public static void main(String... args) {
        int[] nums1 = {1, 7, 5};
        int[] nums2 = {2, 3, 5};
//        int[] nums1 = {1, 10, 4, 4, 2, 7};
//        int[] nums2 = {9, 3, 5, 1, 7, 4};
//        int[] nums1 = {1, 28, 21};
//        int[] nums2 = {9, 21, 20};

        System.out.println(new Problem1818().minAbsoluteSumDiff(nums1, nums2));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        long r = 0;
        ArrayList<int[]> list = new ArrayList<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            list.add(new int[]{d, i});
            r += d;
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a0, int[] a1) {
                return a1[0] - a0[0];
            }
        });
        int maxReduce = 0;
        if (list.get(0)[0] > 0) {
            for (int[] data : list) {
                if (maxReduce >= data[0]) {
                    break;
                }
                for (int i = 0; i < nums1.length; i++) {
                    int d = Math.abs(nums1[i] - nums2[data[1]]);
                    int reduce = data[0] - d;
                    if (reduce > maxReduce) {
                        maxReduce = reduce;
                    }
                }
            }
        }
        return (int) ((r - maxReduce) % mod);
    }
}