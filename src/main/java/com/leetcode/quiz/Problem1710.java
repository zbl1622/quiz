package com.leetcode.quiz;

/**
 * 1710. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1710 {

    public static void main(String... args) {
        int[] array = {1, 2, 5, 9, 5, 9, 5, 5, 5};

        System.out.println(new Problem1710().majorityElement(array));
    }


    public int majorityElement(int[] nums) {
        int c = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == c) {
                count += 1;
            } else {
                if (count == 0) {
                    c = nums[i];
                    count = 1;
                } else {
                    count -= 1;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == c) {
                count += 1;
            }
        }
        if (count <= (nums.length >> 1)) {
            c = -1;
        }
        return c;
    }
}