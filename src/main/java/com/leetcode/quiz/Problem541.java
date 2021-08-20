package com.leetcode.quiz;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem541 {

    public static void main(String... args) {
        String s = "abcdefg";
        int k = 2;

        System.out.println(new Problem541().reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length / k / 2; i++) {
            int startIndex = i * 2 * k;
            for (int j = 0; j < k / 2; j++) {
                int start = startIndex + j;
                int end = startIndex + k - 1 - j;
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
            }
        }
        int l = c.length % (2 * k);
        if (l != 0) {
            int startIndex = c.length - l;
            int length = Math.min(l, k);
            for (int j = 0; j < length / 2; j++) {
                int start = startIndex + j;
                int end = startIndex + length - 1 - j;
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
            }
        }
        return new String(c);
    }
}