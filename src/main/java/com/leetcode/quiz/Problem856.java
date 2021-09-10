package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 856. 括号的分数
 * <p>
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * <p>
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * <p>
 * 示例3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * <p>
 * 示例4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * <p>
 * 提示：
 * <p>
 * S是平衡括号字符串，且只含有(和)。
 * 2 <= S.length <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem856 {

    public static void main(String... args) {
        String s = "(()(()))";

        System.out.println(JSON.toJSONString(new Problem856().scoreOfParentheses(s)));
    }

    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int p = stack.pop();
                if (p == -1) {
                    stack.push(1);
                } else {
                    int v = stack.pop();
                    while (v != -1) {
                        p += v;
                        v = stack.pop();
                    }
                    stack.push(2 * p);
                }
            }
        }
        int r = 0;
        while (!stack.isEmpty()) {
            r += stack.pop();
        }
        return r;
    }
}