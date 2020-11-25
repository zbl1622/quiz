package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 */
public class Problem452 {

    public static void main(String... args) {
//        int[][] points = new int[][]{
//                {10, 16}, {2, 8}, {1, 6}, {7, 12}
//        };
//        int[][] points = new int[][]{
//                {1, 2}, {3, 4}, {5, 6}, {7, 8}
//        };
        int[][] points = new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(new Problem452().findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(t0 -> t0[0]));
        ArrayList<Object> arrows = new ArrayList<>(points.length / 2);
        boolean findFlag = false;
        for (int[] point : points) {
            findFlag = false;
            for (int i = 0; i < arrows.size(); i++) {
                int[] arrow = (int[]) arrows.get(i);
                arrow = calculateIntersection(arrow, point);
                if (arrow != null) {
                    arrows.set(i, arrow);
                    findFlag = true;
                    break;
                }
            }
            if (!findFlag) {
                arrows.add(point);
            }
        }
        return arrows.size();
    }

    public int[] calculateIntersection(int[] a, int[] b) {
        if (b[0] < a[0]) {
            if (b[1] < a[0]) {
                return null;
            } else if (b[1] < a[1]) {
                return new int[]{a[0], b[1]};
            } else {
                return a;
            }
        } else if (b[0] <= a[1]) {
            if (b[1] <= a[1]) {
                return b;
            } else {
                return new int[]{b[0], a[1]};
            }
        } else {
            return null;
        }
    }
}