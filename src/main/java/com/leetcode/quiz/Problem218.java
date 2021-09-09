package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 218. 天际线问题（未解决）
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * <p>
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * <p>
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * <p>
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * <p>
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 * 示例 2：
 * <p>
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings 按 lefti 非递减排序
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-skyline-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem218 {

    public static void main(String... args) {
        int[][] array = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};

//        System.out.println(JSON.toJSONString(new Problem218().getSkyline(array)));
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] data : array) {
            list.add(data[0]);
        }
        int start = 0;
        int end = list.size() - 1;
        int index = 0;
        int number = 5;
        while (start <= end) {
            int center = (start + end) >> 1;
            if (number <= list.get(center)) {
                index = center;
                end = center - 1;
            } else {
                start = center + 1;
            }
        }
        System.out.println(index);
        System.out.println(JSON.toJSONString(list));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<int[]> list = new ArrayList<>(buildings.length * 2);
        for (int[] building : buildings) {
            if (list.isEmpty()) {
                list.add(building);
            } else {
                int start = 0;
                int end = list.size() - 1;
                int index = 0;
                while (start <= end) {
                    int center = (start + end) >> 1;
                    if (building[0] <= list.get(center)[0]) {
                        index = center;
                        end = center - 1;
                    } else {
                        start = center + 1;
                    }
                }
                if (index > 0) {
                    index -= 1;
                }
//                for (int i = index; i < list.size(); i++) {
//                    int[] rect = list.get(i);
//                    if (building[0] >= building[1]) {
//                        break;
//                    }
//                    if (building[0] >= rect[1]) {
//                        continue;
//                    } else if (building[2] <= rect[2]) {
//                        continue;
//                    } else if () {
//
//                    }
//                }
            }
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        return result;
    }
}