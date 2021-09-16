package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 面试题 16.21. 交换和
 * <p>
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例:
 * <p>
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * <p>
 * 示例:
 * <p>
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * 提示：
 * <p>
 * 1 <= array1.length, array2.length <= 100000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProblemInterview1621 {

    public static void main(String... args) {
//        int[] array1 = {4, 1, 2, 1, 1, 2};
//        int[] array2 = {3, 6, 3, 3};
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        System.out.println(JSON.toJSONString(new ProblemInterview1621().findSwapValues(array1, array2)));
    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        int s1 = 0, s2 = 0;
        for (int n : array1) {
            s1 += n;
        }
        for (int n : array2) {
            s2 += n;
        }
        int diff;
        int[] arrayBig, arraySmall;
        if (s1 > s2) {
            diff = s1 - s2;
            arrayBig = array1;
            arraySmall = array2;
        } else {
            diff = s2 - s1;
            arrayBig = array2;
            arraySmall = array1;
        }
        if (diff % 2 != 0) {
            return new int[0];
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int n : arraySmall) {
            hashSet.add(diff + 2 * n);
        }
        for (int n : arrayBig) {
            if (hashSet.contains(2 * n)) {
                return s1 > s2 ? new int[]{n, (2 * n - diff) / 2} : new int[]{(2 * n - diff) / 2, n};
            }
        }
        return new int[0];
    }
}