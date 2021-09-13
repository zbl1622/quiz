package com.leetcode.quiz;

import java.util.HashMap;

/**
 * 447. 回旋镖的数量
 * <p>
 * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * n ==points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem447 {

    public static void main(String... args) {
        int[][] points = {
                {0, 0}, {1, 0}, {2, 0}
        };

        System.out.println(new Problem447().numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        HashMap<Integer, HashMap<Integer, Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int d = dx * dx + dy * dy;
                HashMap<Integer, Integer> mi = hashMap.computeIfAbsent(i, k -> new HashMap<>());
                if (mi.containsKey(d)) {
                    sum += mi.get(d) * 2;
                }
                mi.put(d, mi.getOrDefault(d, 0) + 1);
                HashMap<Integer, Integer> mj = hashMap.computeIfAbsent(j, k -> new HashMap<>());
                if (mj.containsKey(d)) {
                    sum += mj.get(d) * 2;
                }
                mj.put(d, mj.getOrDefault(d, 0) + 1);
            }
        }
        return sum;
    }
}