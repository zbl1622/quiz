package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * <p>
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 */
public class Problem205 {

    public static void main(String... args) {
//        String s = "paper", t = "title";
        String s = "foo", t = "bar";
        System.out.println(String.valueOf(new Problem205().isIsomorphic(s, t)));
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>(s.length());
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            Character c = hashMap.get(b);
            if (c == null) {
                if (hashSet.contains(a)) {
                    return false;
                }
                hashMap.put(b, a);
                hashSet.add(a);
            } else if (c != a) {
                return false;
            }
        }
        return true;
    }
}