package com.leetcode.quiz;

/**
 * 44. 通配符匹配
 * 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符?和*。
 * 示例1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释:'*' 可以匹配任意字符串。
 * 示例3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释:'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释:第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem44 {

    public static void main(String... args) {

        System.out.println(new Problem44().isMatch("adceb", "*a*b"));
        System.out.println(new Problem44().isMatch("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        char cs;
        char cp;
        boolean[][] dp = new boolean[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            cs = s.charAt(i);
            for (int j = 0; j < p.length(); j++) {
                cp = p.charAt(j);
                if (cs == ' ') {
                    if (cp == ' ') {
                        dp[i][j] = true;
                    } else if (cp == '*') {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (cs == cp || cp == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length() - 1][p.length() - 1];
    }
}