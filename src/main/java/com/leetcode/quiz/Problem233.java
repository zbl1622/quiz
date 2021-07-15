package com.leetcode.quiz;

/**
 * 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：6
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 2 * 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem233 {

    public static void main(String... args) {

        System.out.println(new Problem233().countDigitOne(1231));
    }

    //聪明办法
    public int countDigitOne(int n) {
        long[] g = new long[9];
        int x = 1, b = 1;
        for (int i = 0; i < g.length; i++) {
            g[i] = x;
            b *= 10;
            x = b + 10 * x;
        }
        long s = 0;
        int m = n;
        int i = 0;
        b = 1;
        int r = 0;
        while (m > 0) {
            x = m % 10;
            m /= 10;
            r += b * x;
            if (x == 1) {
                s += r - b + 1;
            } else if (x > 1) {
                s += b;
            }
            if (i > 0) {
                s += x * g[i - 1];
            }
            b *= 10;
            i += 1;
        }
        return (int) s;
    }

//    //笨办法
//    public int countDigitOne(int n) {
//        int s = 0;
//        for (int i = 1; i <= n; i++) {
//            int x = i;
//            int count = 0;
//            while (x > 0) {
//                int r = x % 10;
//                if (r == 1) {
//                    count += 1;
//                }
//                x = (x - r) / 10;
//            }
//            s += count;
//        }
//        return s;
//    }
}