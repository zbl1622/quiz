package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]表示一个从starti到endi的闭区间。
 * <p>
 * 如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。
 * <p>
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi，那么我们称整数x被覆盖了。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * <p>
 * 示例 2：
 * <p>
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1893 {

    public static void main(String... args) {
//        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
//        int left = 2, right = 5;
//        int[][] ranges = {{1, 10}, {10, 20}};
//        int left = 21, right = 21;
        int[][] ranges = {{2, 2}, {3, 3}, {1, 1}};
        int left = 1, right = 3;

        System.out.println(new Problem1893().isCovered(ranges, left, right));
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{left, right});
        for (int[] range : ranges) {
            for (int i = 0; i < list.size(); i++) {
                int[] span = list.get(i);
                if (range[0] > span[0]) {
                    if (range[1] < span[1]) {
                        list.add(new int[]{range[1] + 1, span[1]});
                        span[1] = range[0] - 1;
                    } else if (range[0] <= span[1]) {
                        span[1] = range[0] - 1;
                    }
                } else {
                    if (range[1] < span[1]) {
                        if (range[1] >= span[0]) {
                            span[0] = range[1] + 1;
                        }
                    } else {
                        list.remove(i);
                        i -= 1;
                    }
                }
            }
        }
        return list.isEmpty();
    }
}