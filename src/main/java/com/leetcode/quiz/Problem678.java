package com.leetcode.quiz;

/**
 * 678. 有效的括号字符串
 * <p>
 * 给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 (必须有相应的右括号 )。
 * 任何右括号 )必须有相应的左括号 (。
 * 左括号 ( 必须在对应的右括号之前 )。
 * *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "(*)"
 * 输出: True
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(*))"
 * 输出: True
 * <p>
 * 注意:
 * <p>
 * 字符串大小将在 [1，100] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem678 {

    public static void main(String... args) {
//        String s = "(*)";
//        String s = "(*))";
//        String s = "(*)*)*";
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        System.out.println(new Problem678().checkValidString(s));
    }

    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int stack = 0;
        int star = 0;
        for (char c : chars) {
            if (c == '(') {
                stack += 1;
            } else if (c == ')') {
                stack -= 1;
                if (stack < 0) {
                    if (star > 0) {
                        star -= 1;
                        stack += 1;
                    } else {
                        return false;
                    }
                }
            } else {
                star += 1;
            }
        }
        boolean result = star >= Math.abs(stack);
        if (!result) {
            return false;
        }
        stack = 0;
        star = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == ')') {
                stack += 1;
            } else if (c == '(') {
                stack -= 1;
                if (stack < 0) {
                    if (star > 0) {
                        star -= 1;
                        stack += 1;
                    } else {
                        return false;
                    }
                }
            } else {
                star += 1;
            }
        }
        return star >= Math.abs(stack);
    }
}