package com.leetcode.quiz;

import java.util.Stack;

/**
 * 224
 */
public class Problem224 {

    public static void main(String... args) {
//        System.out.println(new Problem224().calculate(" 2-1 + 2 "));
        System.out.println(new Problem224().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        int index = 0;
        int a = 0, b = 0;
        int operation = 1;
        Stack<Object> stack = new Stack<>();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {

            } else if (c == '+') {
                a = a + operation * b;
                b = 0;
                operation = 1;
            } else if (c == '-') {
                a = a + operation * b;
                b = 0;
                operation = -1;
            } else if (c == '(') {
                a = a + operation * b;
                stack.push(new int[]{a, operation});
                a = 0;
                b = 0;
                operation = 1;
            } else if (c == ')') {
                a = a + operation * b;
                int[] savedStatus = (int[]) stack.pop();
                savedStatus[0] = savedStatus[0] + savedStatus[1] * a;
                a = savedStatus[0];
                b = 0;
                operation = 1;
            } else {
                b = b * 10 + (c - '0');
            }
            index += 1;
        }
        return a + operation * b;
    }
}
