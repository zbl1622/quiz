package com.leetcode.quiz;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * <p>
 * 注意:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 */
public class Problem714 {

    public static void main(String... args) {
//        int[] array = {1, 3, 2, 8, 4, 9};
//        int fee = 2;
//        int[] array = {4, 5, 2, 4, 3, 3, 1, 2, 5, 4};
//        int fee = 1;
        int[] array = {2, 1, 4, 4, 2, 3, 2, 5, 1, 2};
        int fee = 1;

        System.out.println(new Problem714().maxProfit(array, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int not_have = 0;
        int have = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            not_have = Math.max(not_have, have + prices[i]);
            have = Math.max(have, not_have - prices[i] - fee);
        }
        return not_have;
    }
}