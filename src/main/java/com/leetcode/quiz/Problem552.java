package com.leetcode.quiz;

/**
 * 552. 学生出勤记录 II
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：n = 10101
 * 输出：183236316
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem552 {

    public static void main(String... args) {
        int n = 10101;

        System.out.println(new Problem552().checkRecord(n));
    }

    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }
        long mod = 1000000007;
        long[] dpA0L0 = new long[n];
        long[] dpA0L1 = new long[n];
        long[] dpA0L2 = new long[n];
        long[] dpA1L0 = new long[n];
        long[] dpA1L1 = new long[n];
        long[] dpA1L2 = new long[n];
        dpA0L0[0] = 1;
        dpA0L1[0] = 1;
        dpA1L0[0] = 1;
        for (int i = 1; i < n; i++) {
            dpA0L0[i] = (dpA0L0[i - 1] + dpA0L1[i - 1] + dpA0L2[i - 1]) % mod;
            dpA0L1[i] = (dpA0L0[i - 1]) % mod;
            dpA0L2[i] = (dpA0L1[i - 1]) % mod;
            dpA1L0[i] = (dpA0L0[i - 1] + dpA0L1[i - 1] + dpA0L2[i - 1] + dpA1L0[i - 1] + dpA1L1[i - 1] + dpA1L2[i - 1]) % mod;
            dpA1L1[i] = (dpA1L0[i - 1]) % mod;
            dpA1L2[i] = (dpA1L1[i - 1]) % mod;
        }
        return (int) ((dpA0L0[n - 1] + dpA0L1[n - 1] + dpA0L2[n - 1] + dpA1L0[n - 1] + dpA1L1[n - 1] + dpA1L2[n - 1]) % mod);
    }
}