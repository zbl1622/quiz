package com.leetcode.quiz;

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem516 {

    public static void main(String... args) {
        String s = "bbbab";

        System.out.println(new Problem516().longestPalindromeSubseq(s));
    }

    /**
     * 思路就是将s反转，然后就s与反转s的最长公共子序列
     */
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length + 1][chars.length + 1];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                int x = i + 1;
                int y = j + 1;
                if (chars[i] == chars[chars.length - j - 1]) {
                    dp[x][y] = dp[x - 1][y - 1] + 1;
                } else {
                    dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
                }
            }
        }
        return dp[chars.length][chars.length];
    }
}