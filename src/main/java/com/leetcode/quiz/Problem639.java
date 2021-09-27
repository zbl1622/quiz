package com.leetcode.quiz;

/**
 * 639. 解码方法 II
 * <p>
 * 一条包含字母A-Z 的消息通过以下的方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 * <p>
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 * <p>
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 * <p>
 * 由于答案数目可能非常大，返回对 10^9 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "*"
 * 输出：9
 * 解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
 * 可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
 * 因此，"*" 总共有 9 种解码方法。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "1*"
 * 输出：18
 * 解释：这一条编码消息可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条。
 * 每种消息都可以由 2 种方法解码（例如，"11" 可以解码成 "AA" 或 "K"）。
 * 因此，"1*" 共有 9 * 2 = 18 种解码方法。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "2*"
 * 输出：15
 * 解释：这一条编码消息可以表示 "21"、"22"、"23"、"24"、"25"、"26"、"27"、"28" 或 "29" 中的任意一条。
 * "21"、"22"、"23"、"24"、"25" 和 "26" 由 2 种解码方法，但 "27"、"28" 和 "29" 仅有 1 种解码方法。
 * 因此，"2*" 共有 (6 * 2) + (3 * 1) = 12 + 3 = 15 种解码方法。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s[i] 是 0 - 9 中的一位数字或字符 '*'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem639 {

    public static void main(String... args) {
//        String s = "*";
//        String s = "1*";
//        String s = "2*";
//        String s = "**";
//        String s = "*1*1*0";
        String s = "1*6*7*1*9*6*2*9*2*3*3*6*3*2*2*4*7*2*9*6*0*6*4*4*1*6*9*0*5*9*2*5*7*7*0*6*9*7*1*5*5*9*3*0*4*9*2*6*2*5*7*6*1*9*4*5*8*4*7*4*2*7*1*2*1*9*1*3*0*6*";

        System.out.println(new Problem639().numDecodings(s));
    }

    public int numDecodings(String s) {
        int mod = 1000000007;
        char[] chars = s.toCharArray();
        long[] dps = new long[chars.length];
        long[] dpd = new long[chars.length];
        if (chars[0] == '*') {
            dps[0] = 9;
        } else if (chars[0] == '0') {
            dps[0] = 0;
        } else {
            dps[0] = 1;
        }
        for (int i = 1; i < chars.length; i++) {
            long lastTotal = dps[i - 1] + dpd[i - 1];
            if (chars[i] == '*') {
                dps[i] = lastTotal * 9 % mod;
            } else if (chars[i] == '0') {
                dps[i] = 0;
            } else {
                dps[i] = lastTotal;
            }
            long lastTwoTotal = 1;
            if (i > 1) {
                lastTwoTotal = dps[i - 2] + dpd[i - 2];
            }
            if (chars[i] == '*') {
                if (chars[i - 1] == '*') {
                    dpd[i] = lastTwoTotal * 15 % mod;
                } else if (chars[i - 1] == '1') {
                    dpd[i] = lastTwoTotal * 9 % mod;
                } else if (chars[i - 1] == '2') {
                    dpd[i] = lastTwoTotal * 6 % mod;
                } else {
                    dpd[i] = 0;
                }
            } else {
                if (chars[i - 1] == '*') {
                    if (chars[i] - '0' <= 6) {
                        dpd[i] = lastTwoTotal * 2 % mod;
                    } else {
                        dpd[i] = lastTwoTotal;
                    }
                } else if (chars[i - 1] == '0') {
                    dpd[i] = 0;
                } else if (chars[i - 1] == '1') {
                    dpd[i] = lastTwoTotal;
                } else if (chars[i - 1] == '2') {
                    if (chars[i] - '0' <= 6) {
                        dpd[i] = lastTwoTotal;
                    } else {
                        dpd[i] = 0;
                    }
                } else {
                    dpd[i] = 0;
                }
            }
        }
        return (int) ((dps[chars.length - 1] + dpd[chars.length - 1]) % mod);
    }
}