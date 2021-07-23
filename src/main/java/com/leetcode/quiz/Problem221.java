package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem221 {

    public static void main(String... args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//        char[][] matrix = {{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}};
        char[][] matrix = {{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}};

        System.out.println(new Problem221().maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][][] dp = new int[height][width][3];
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                    dp[i][j][2] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j][0] = dp[i][j - 1][0] + 1;
                    } else {
                        dp[i][j][0] = 1;
                    }
                    if (i > 0) {
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                    } else {
                        dp[i][j][1] = 1;
                    }
                    if (j > 0 && i > 0) {
                        if (dp[i][j][0] >= dp[i - 1][j - 1][2] + 1 && dp[i][j][1] >= dp[i - 1][j - 1][2] + 1) {
                            dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                        } else {
                            dp[i][j][2] = Math.min(dp[i][j][0], dp[i][j][1]);
                        }
                    } else {
                        dp[i][j][2] = 1;
                    }
                    if (dp[i][j][2] > max) {
                        max = dp[i][j][2];
                    }
                }
            }
        }
        return max * max;
    }
}