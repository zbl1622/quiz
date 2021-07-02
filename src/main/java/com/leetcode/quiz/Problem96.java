package com.leetcode.quiz;

/**
 * 96. 不同的二叉搜索树
 */
public class Problem96 {

    public static void main(String... args) {

        System.out.println(new Problem96().numTrees(1));
        System.out.println(new Problem96().numTrees(3));
        System.out.println(new Problem96().numTrees(4));
        System.out.println(new Problem96().numTrees(5));
    }

    public int numTrees(int n) {
        int[] r = new int[n + 1];
        r[0] = 1;
        r[1] = 1;
        for (int i = 2; i <= n; i++) {
            int s = 0;
            if (i % 2 == 0) {
                int l = i / 2;
                for (int j = 0; j < l; j++) {
                    s += r[j] * r[i - j - 1];
                }
                s *= 2;
            } else {
                int l = (i + 1) / 2;
                for (int j = 0; j < l - 1; j++) {
                    s += r[j] * r[i - j - 1];
                }
                s *= 2;
                s += r[i / 2] * r[i / 2];
            }
            r[i] = s;
        }
        return r[n];
    }
}