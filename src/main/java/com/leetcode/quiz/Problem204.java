package com.leetcode.quiz;

import java.util.ArrayList;

/**
 * 204. 计数质数
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 */
public class Problem204 {

    public static void main(String... args) {
        int n = 10;
//        int n = 4;
        System.out.println(String.valueOf(new Problem204().countPrimes(n)));
    }

    public int countPrimes(int n) {
        ArrayList<Integer> list = new ArrayList<>(n / 2);
        if (n > 2) {
            list.add(2);
        }
        label:
        for (int i = 3; i < n; i += 2) {
            for (int m : list) {
                if (m > (int) Math.sqrt(n)) {
                    break;
                }
                if (i % m == 0) {
                    continue label;
                }
            }
            list.add(i);
        }
        return list.size();
    }
}