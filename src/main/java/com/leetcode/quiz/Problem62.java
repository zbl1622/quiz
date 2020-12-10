package com.leetcode.quiz;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class Problem62 {

    public static void main(String... args) {
//        int m = 7, n = 3;
//        int m = 10, n = 10;
        int m = 38, n = 10;
        System.out.println(String.valueOf(new Problem62().uniquePaths(m, n)));
    }

    public int uniquePaths(int m, int n) {
        m -= 1;
        n -= 1;
        int s = m + n;
        n = Math.min(n, m);
        return c(n, s);
    }

    private HashMap<String, Integer> hashMap = new HashMap<>();

    public int c(int m, int n) {
        if (m == 0) {
            return 1;
        } else if (m == 1) {
            return n;
        } else if (n == m) {
            return 1;
        } else {
            String key = m + "_" + n;
            Integer value = hashMap.get(key);
            if (value == null) {
                value = c(m - 1, n - 1) + c(m, n - 1);
                hashMap.put(key, value);
            }
            return value;
        }
    }
}