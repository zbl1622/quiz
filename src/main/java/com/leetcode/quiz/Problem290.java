package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 290. 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 */
public class Problem290 {

    public static void main(String... args) {
//        String pattern = "abba";
//        String s = "dog cat cat dog";
//        String pattern = "abba";
//        String s = "dog cat cat fish";
//        String pattern = "aaaa";
//        String s = "dog cat cat dog";
//        String pattern = "abba";
//        String s = "dog dog dog dog";
        String pattern = "abc";
        String s = "dog cat dog";

        System.out.println(new Problem290().wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (array.length != chars.length) {
            return false;
        }
        HashMap<Character, String> hashMap = new HashMap<>();
        HashMap<String, Character> hashMap2 = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            char c = chars[i];
            String string = array[i];
            if (hashMap.containsKey(c)) {
                if (!string.equals(hashMap.get(c))) {
                    return false;
                }
            } else {
                hashMap.put(c, string);
            }
            if (hashMap2.containsKey(string)) {
                if (c != hashMap2.get(string)) {
                    return false;
                }
            } else {
                hashMap2.put(string, c);
            }
        }
        return true;
    }
}