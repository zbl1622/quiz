package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

/**
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1030 {

    public static void main(String... args) {
        System.out.println(JSON.toJSONString(new Problem1030().allCellsDistOrder(2, 3, 1, 2)));
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDistance = Math.max(Math.max(r0 + c0, R - r0 + c0), Math.max(r0 + C - c0, R - r0 + C - c0));
        int[][] result = new int[R * C][];
        int writeIndex = 0;
        int j = 0;
        int dr = 0;
        for (int d = 0; d <= maxDistance; d++) {
            int top = Math.max(0, r0 - d);
            int bottom = Math.min(R - 1, r0 + d);
            for (int i = top; i <= bottom; i++) {
                dr = d - Math.abs(i - r0);
                j = c0 - dr;
                if (j >= 0) {
                    result[writeIndex] = new int[]{i, j};
                    writeIndex += 1;
                }
                if (dr > 0) {
                    j = c0 + dr;
                    if (j < C) {
                        result[writeIndex] = new int[]{i, j};
                        writeIndex += 1;
                    }
                }

            }
        }
        return result;
    }
}