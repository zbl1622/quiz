package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 如果存在多个答案，只需返回 任意一个 。
 * <p>
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * <p>
 * 示例 2：
 * <p>
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * <p>
 * 示例 3：
 * <p>
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * <p>
 * 示例 4：
 * <p>
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * <p>
 * 示例 5：
 * <p>
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 */
public class Problem166 {

    public static void main(String... args) {
//        int numerator = 4, denominator = 333;
//        int numerator = 40120, denominator = 125;
        int numerator = -1, denominator = -2147483648;
        System.out.println(String.valueOf(new Problem166().fractionToDecimal(numerator, denominator)));
    }

    public String fractionToDecimal(long numerator, long denominator) {//必须把传入的数值变成long类型，否则-2147483648会溢出
        HashMap<String, Integer> indexMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && denominator > 0) {
            numerator = -numerator;
            sb.append('-');
        } else if (denominator < 0 && numerator > 0) {
            denominator = -denominator;
            sb.append('-');
        }
        long n = numerator / denominator;
        sb.append(n);
        int index = sb.length();
        if (numerator != n * denominator) {
            sb.append('.');
            numerator = numerator - n * denominator;
            while (numerator != 0) {
                index += 1;
                numerator *= 10;
                n = numerator / denominator;
                numerator = numerator - n * denominator;
                String key = n + "_" + numerator;
                if (indexMap.containsKey(key)) {
                    sb.insert(indexMap.get(key), "(");
                    sb.append(')');
                    return sb.toString();
                } else {
                    sb.append(n);
                    indexMap.put(key, index);
                }
            }
        }
        return sb.toString();
    }
}