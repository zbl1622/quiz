package com.leetcode.quiz;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 547. 省份数量
 * <p>
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 */
public class Problem547 {

    public static void main(String... args) {
//        int[][] isConnected = {
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        };
        int[][] isConnected = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        System.out.println(new Problem547().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int s = 0;
        HashMap<Integer, HashSet<Integer>> hashmap = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < isConnected.length; i++) {
            flag = false;
            HashSet<Integer> existSet = null;
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] != 0) {
                    flag = true;
                    if (existSet == null) {
                        existSet = hashmap.get(j);
                    } else {
                        HashSet<Integer> set = hashmap.get(j);
                        if (set != existSet) {
                            hashmap.remove(j);
                            s -= 1;
                            for (Integer integer : set) {
                                existSet.add(integer);
                                hashmap.put(integer, existSet);
                            }
                        }
                    }
                    existSet.add(i);
                    hashmap.put(i, existSet);
                }
            }
            if (!flag) {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                hashmap.put(i, set);
                s += 1;
            }
        }
        return s;
    }
}