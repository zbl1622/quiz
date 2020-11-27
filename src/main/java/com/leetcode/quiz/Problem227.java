package com.leetcode.quiz;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 */
public class Problem227 {

    public static void main(String... args) {
//        System.out.println(new Problem224().calculate(" 2-1 + 2 "));
        System.out.println(new Problem227().calculate("3+2*2"));
    }

    public int calculate(String s) {
        int index = 0;
        int a = 0, b = 0;
        int operation = 1;//+ 1,- 2,* 3,/ 4
        Stack<Object> stack = new Stack<>();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {

            } else if (c == '+') {
                a = calculate(a, b, operation);
                b = 0;
                if (operation > 2) {
                    int[] savedStatus = (int[]) stack.pop();
                    savedStatus[0] = calculate(savedStatus[0], a, savedStatus[1]);
                    a = savedStatus[0];
                }
                operation = 1;
            } else if (c == '-') {
                a = calculate(a, b, operation);
                b = 0;
                if (operation > 2) {
                    int[] savedStatus = (int[]) stack.pop();
                    savedStatus[0] = calculate(savedStatus[0], a, savedStatus[1]);
                    a = savedStatus[0];
                }
                operation = 2;
            } else if (c == '*') {
                if (operation < 3) {
                    stack.push(new int[]{a, operation});
                    a = b;
                } else {
                    a = calculate(a, b, operation);
                }
                b = 0;
                operation = 3;
            } else if (c == '/') {
                if (operation < 3) {
                    stack.push(new int[]{a, operation});
                    a = b;
                } else {
                    a = calculate(a, b, operation);
                }
                b = 0;
                operation = 4;
            } else {
                b = b * 10 + (c - '0');
            }
            index += 1;
        }
        a = calculate(a, b, operation);
        while (!stack.empty()) {
            int[] savedStatus = (int[]) stack.pop();
            a = calculate(savedStatus[0], a, savedStatus[1]);
        }
        return a;
    }

    private int calculate(int a, int b, int operation) {
        if (operation == 1) {
            return a + b;
        } else if (operation == 2) {
            return a - b;
        } else if (operation == 3) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
