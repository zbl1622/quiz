package com.leetcode.quiz;

import java.util.HashSet;

/**
 * 827. 最大人工岛(正确但是超时)
 * <p>
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格0 变成1 。
 * <p>
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * <p>
 * 岛屿 由一组上、下、左、右四个方向相连的1 形成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * <p>
 * 示例 2:
 * <p>
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * <p>
 * 示例 3:
 * <p>
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] 为 0 或 1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/making-a-large-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem827 {

    public static void main(String... args) {
        int[][] grid = {
                {1, 0, 1},
                {0, 1, 0},
                {0, 1, 0}
        };

        System.out.println(new Problem827().largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {
        boolean hasZero = false;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    grid[i][j] = 1;
                    HashSet<Integer> hashSet = new HashSet<>();
                    checkArea(grid, hashSet, i, j);
                    if (hashSet.size() > max) {
                        max = hashSet.size();
                    }
                    grid[i][j] = 0;
                }
            }
        }
        if (!hasZero) {
            return grid.length * grid.length;
        } else {
            return max;
        }
    }

    public void checkArea(int[][] grid, HashSet<Integer> hashSet, int i, int j) {
        int key = i * 1000 + j;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || hashSet.contains(key)) {
            return;
        } else if (grid[i][j] == 1) {
            hashSet.add(key);
            checkArea(grid, hashSet, i - 1, j);
            checkArea(grid, hashSet, i, j - 1);
            checkArea(grid, hashSet, i + 1, j);
            checkArea(grid, hashSet, i, j + 1);
        }
    }

}