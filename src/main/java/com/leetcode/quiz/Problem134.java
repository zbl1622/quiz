package com.leetcode.quiz;

/**
 * 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 */
public class Problem134 {

    public static void main(String... args) {
//        int[] gas = new int[]{1, 2, 3, 4, 5};
//        int[] cost = new int[]{3, 4, 5, 1, 2};
        int[] gas = new int[]{5, 1, 2, 3, 4};
        int[] cost = new int[]{4, 4, 1, 5, 1};
        System.out.println(String.valueOf(new Problem134().canCompleteCircuit(gas, cost)));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s = 0, c = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            s += gas[i] - cost[i];
            c += gas[i] - cost[i];
            if (c < 0) {
                c = 0;
                index = i + 1;
            }
        }
        if (s >= 0) {
            return index;
        } else {
            return -1;
        }
    }
}