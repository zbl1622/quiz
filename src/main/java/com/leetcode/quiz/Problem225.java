package com.leetcode.quiz;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 */
public class Problem225 {

    public static void main(String... args) {
    }

    static class MyStack {

        private LinkedList<Integer> list = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            list.addFirst(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return list.pop();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return list.getFirst();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return list.isEmpty();
        }
    }
}
