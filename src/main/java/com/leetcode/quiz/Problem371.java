package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 371. 两整数之和
 * <p>
 * 给你两个整数 a 和 b ，不使用 运算符+ 和-，计算并返回两整数之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：a = 2, b = 3
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * -1000 <= a, b <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem371 {

    public static void main(String... args) {
//        int a = 1, b = 2;
        int a = -2, b = 1;

        System.out.println(JSON.toJSONString(new Problem371().getSum(a, b)));
    }

    public int getSum(int a, int b) {
        System.out.println("a=" + getBin(a));
        System.out.println("b=" + getBin(b));
        int ax, bx;
        int c = 0;
        int tc = 0;
        int x = 0;
        int n = 0;
        for (int i = 0; i < 32; i++) {
            ax = a & 1;
            bx = b & 1;
            x = ax ^ bx;
            tc = (ax & bx) | (x & c);
            x = x ^ c;
            c = tc;
            n = n | (x << i);
            a = a >> 1;
            b = b >> 1;
        }
        return n;
    }

    public String getBin(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            sb.insert(0, bit);
            n = n >> 1;
        }
        return sb.toString();
    }
}