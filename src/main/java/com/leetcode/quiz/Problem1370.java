package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * <p>
 * 1、从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 2、从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 3、重复步骤 2 ，直到你没法从 s 中选择字符。
 * 4、从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 5、从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 6、重复步骤 5 ，直到你没法从 s 中选择字符。
 * 7、重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * <p>
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 */
public class Problem1370 {

    public static void main(String... args) {
        System.out.println(new Problem1370().sortString("aaaabbbbcccc"));
    }

    public String sortString(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        ArrayList<Stack<Character>> list = new ArrayList<>();
        Stack<Character> stack = null;
        char lastChar = ' ';
        for (char c : array) {
            if (c != lastChar) {
                stack = new Stack<>();
                list.add(stack);
                lastChar = c;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        int left = 0, right = list.size() - 1;
        int status = 0;//0 步骤1到2,1 步骤4到5
        while (!list.isEmpty()) {
            if (status == 0) {
                char c = list.get(left).pop();
                sb.append(c);
                if (list.get(left).empty()) {
                    list.remove(left);
                    right = list.size() - 1;
                } else {
                    left += 1;
                }
                if (left > right) {
                    left = 0;
                    right = list.size() - 1;
                    status = 1;
                }
            } else {
                char c = list.get(right).pop();
                sb.append(c);
                if (list.get(right).empty()) {
                    list.remove(right);
                }
                right -= 1;
                if (left > right) {
                    right = list.size() - 1;
                    status = 0;
                }
            }
        }
        return sb.toString();
    }
}