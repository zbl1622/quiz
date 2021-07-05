package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem394 {

    public static void main(String... args) {

        System.out.println(new Problem394().decodeString("3[a]2[bc]"));
        System.out.println(new Problem394().decodeString("3[a2[c]]"));
        System.out.println(new Problem394().decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
        char[] data = s.toCharArray();
        Stack<Object[]> stack = new Stack<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int savedNumber = 0;
        while (index < data.length) {
            char c = data[index];
            if (c == '[') {
                stack.push(new Object[]{sb, savedNumber});
                sb = new StringBuilder();
                savedNumber = 0;
                index += 1;
            } else if (c == ']') {
                index += 1;
                StringBuilder savedSb = sb;
                Object[] objects = stack.pop();
                sb = (StringBuilder) objects[0];
                appendStringByCount(sb, savedSb.toString(), (Integer) objects[1]);
            } else if (c >= 'a' && c <= 'z') {
                Object[] r = readString(data, index);
                index += (int) r[1];
                sb.append((String) r[0]);
            } else if (c >= '0' && c <= '9') {
                int[] r = readNumber(data, index);
                index += r[1];
                savedNumber = r[0];
            }
        }
        return sb.toString();
    }

    private Object[] readString(char[] data, int index) {
        StringBuilder sb = new StringBuilder();
        int i = index;
        while (i < data.length && data[i] >= 'a' && data[i] <= 'z') {
            sb.append(data[i]);
            i += 1;
        }
        return new Object[]{
                sb.toString(), i - index
        };
    }

    private int[] readNumber(char[] data, int index) {
        int s = 0;
        int i = index;
        while (i < data.length && data[i] >= '0' && data[i] <= '9') {
            s *= 10;
            s += data[i] - '0';
            i += 1;
        }
        if (s == 0) {
            s = 1;
        }
        return new int[]{
                s, i - index
        };
    }

    private void appendStringByCount(StringBuilder sb, String string, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(string);
        }
    }
}