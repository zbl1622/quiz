package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 */
public class Problem454 {

    public static void main(String... args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        System.out.println(String.valueOf(new Problem454().fourSumCount(A, B, C, D)));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int s = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int key = A[i] + B[j];
                hashMap.merge(key, 1, Integer::sum);
            }
        }
        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                int key = -C[k] - D[l];
                if (hashMap.containsKey(key)) {
                    s += hashMap.get(key);
                }
            }
        }
        return s;
    }
}