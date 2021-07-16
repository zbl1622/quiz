package com.leetcode.quiz;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem64 {

    public static void main(String... args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(new Problem64().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        int[][] path = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 && j == 0) {
                    path[i][j] = grid[i][j];
                } else if (i > 0 && j == 0) {
                    path[i][j] = grid[i][j] + path[i - 1][j];
                } else if (i == 0 && j > 0) {
                    path[i][j] = grid[i][j] + path[i][j - 1];
                } else {
                    path[i][j] = grid[i][j] + Math.min(path[i - 1][j], path[i][j - 1]);
                }
            }
        }
        return path[width - 1][height - 1];
    }
}