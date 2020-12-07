package com.leetcode.quiz;

/**
 * 861. 翻转矩阵后的得分
 * <p>
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 */
public class Problem861 {

    public static void main(String... args) {
        int[][] array = new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        System.out.println(String.valueOf(new Problem861().matrixScore(array)));
    }

    public int matrixScore(int[][] A) {
        //按首列翻转
        int[] flags = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            flags[i] = A[i][0] ^ 1;
        }
        //计算除首列外的列
        int sum = A.length * (1 << A[0].length - 1);
        for (int j = 1; j < A[0].length; j++) {
            int s = 0;
            for (int i = 0; i < A.length; i++) {
                s += flags[i] ^ A[i][j];
            }
            sum += Math.max(s, A.length - s) * (1 << A[0].length - j - 1);
        }
        return sum;
    }
}