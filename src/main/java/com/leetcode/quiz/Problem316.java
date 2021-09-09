package com.leetcode.quiz;

import java.util.Stack;

/**
 * 316. 去除重复字母（未解决）
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * <p>
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 */
public class Problem316 {

    public static void main(String... args) {
        String s = "bcabc";
//        String s = "cbacdcbc";

        System.out.println(new Problem316().removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = stack.indexOf(c);
            if (index == -1) {
                stack.push(c);
            } else {
                if (index + 1 < stack.size() && c > stack.get(index + 1)) {
                    stack.remove(index);
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int c : stack) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}