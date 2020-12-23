package com.leetcode.quiz;

import java.util.Arrays;

/**
 * 387. 字符串中的第一个唯一字符
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 */
public class Problem387 {

    public static void main(String... args) {
//        String s = "leetcode";
        String s = "loveleetcode";

        System.out.println(new Problem387().firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (array[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}