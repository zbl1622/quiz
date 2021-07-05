package com.leetcode.quiz;

import java.util.Arrays;

/**
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 */
public class Problem1833 {

    public static void main(String... args) {
        int[] array = {1, 3, 2, 4, 1};
        int coins = 7;

        System.out.println(new Problem1833().maxIceCream(array, coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int s = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                s += 1;
                coins -= cost;
            }
        }
        return s;
    }
}