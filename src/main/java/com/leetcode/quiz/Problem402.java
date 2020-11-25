package com.leetcode.quiz;

/**
 * 402. 移掉K位数字
 * <p>
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 */
public class Problem402 {

    public static void main(String... args) {
        System.out.println(new Problem402().removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        } else {
            for (int i = 0; i < k; i++) {
                num = removeOneDigits(num);
            }
            return num;
        }
    }

    private final StringBuilder sb = new StringBuilder();

    private String removeOneDigits(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                sb.setLength(0);
                sb.append(num, 0, i);
                sb.append(num, i + 1, num.length());
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) != '0') {
                        return sb.substring(j);
                    }
                }
                return "0";
            }
        }
        return num.substring(0, num.length() - 1);
    }
}