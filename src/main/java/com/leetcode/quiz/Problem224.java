package com.leetcode.quiz;

/**
 * 224
 */
public class Problem224 {

    public static void main(String... args) {
        System.out.println(new Problem224().calculate(" 2-1 + 2 "));
    }

    public int calculate(String s) {
        return 0;
    }

    public int calculate(String s, int index) {
        int a = 0, b = 0;
        int operation = 1;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {

            } else if (c == '+') {

            } else if (c == '-') {

            } else if (c == '(') {
                return a + operation * calculate(s, index + 1);
            } else if (c == ')') {

            } else {
                b = b * 10 + (c - '0');
            }
            index += 1;
        }
        return a + operation * b;
    }
}
