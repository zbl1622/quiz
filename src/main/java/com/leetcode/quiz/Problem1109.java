package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 1109. 航班预订统计
 * <p>
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 * <p>
 * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * <p>
 * 示例 2：
 * <p>
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 10^4
 * 1 <= bookings.length <= 2 * 10^4
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1109 {

    public static void main(String... args) {
        int[][] array = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}

        };
        int n = 5;

        System.out.println(JSON.toJSONString(new Problem1109().corpFlightBookings(array, n)));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] d = new int[n + 1];
        int[] r = new int[n];
        for (int[] booking : bookings) {
            d[booking[0] - 1] += booking[2];
            d[booking[1]] -= booking[2];
        }
        r[0] = d[0];
        for (int i = 1; i < n; i++) {
            r[i] = r[i - 1] + d[i];
        }
        return r;
    }
}