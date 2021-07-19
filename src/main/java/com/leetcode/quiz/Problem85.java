package com.leetcode.quiz;

/**
 * 85. 最大矩形
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * <p>
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem85 {

    public static void main(String... args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        System.out.println(new Problem85().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int width = matrix.length;
        if (width == 0) {
            return 0;
        }
        int height = matrix[0].length;
        int max = 0;
        int[][] dp = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j] = 1 + dp[i][j - 1];
                    } else {
                        dp[i][j] = 1;
                    }
                    int minLength = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        minLength = Math.min(dp[k][j], minLength);
                        if (minLength == 0) {
                            break;
                        }
                        max = Math.max((i - k + 1) * minLength, max);
                    }
                }
            }
        }
        return max;
    }
}