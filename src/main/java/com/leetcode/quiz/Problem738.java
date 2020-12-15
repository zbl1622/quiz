package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 738. 单调递增的数字
 * <p>
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * <p>
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * <p>
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * <p>
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 */
public class Problem738 {

    public static void main(String... args) {
//        int n = 10;
        int n = 100;
//        int n = 1234;
//        int n = 332;

        System.out.println(new Problem738().monotoneIncreasingDigits(n));
    }

    public int monotoneIncreasingDigits(int N) {
        int[] array = new int[16];
        int index = 0;
        while (N > 0) {
            int d = N / 10;
            array[index] = N - d * 10;
            index += 1;
            N = d;
        }
        int i = index - 1;
        while (i > 0) {
            if (array[i - 1] < array[i]) {
                for (; i < index; i++) {
                    if (array[i - 1] < array[i]) {
                        Arrays.fill(array, 0, i, 9);
                        array[i] -= 1;
                        if (array[i] < 0) {
                            array[i] = 9;
                            array[i + 1] -= 1;
                        }
                    } else {
                        break;
                    }
                }
                break;
            }
            i -= 1;
        }

        int s = 0;
        for (i = index - 1; i >= 0; i -= 1) {
            s *= 10;
            s += array[i];
        }
        return s;
    }
}