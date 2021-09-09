package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 743. 网络延迟时间(未解决)
 * 有 n 个网络节点，标记为1到 n。
 * <p>
 * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem743 {

    public static void main(String... args) {
        int[][] array = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;

        System.out.println(JSON.toJSONString(new Problem743().networkDelayTime(array, n, k)));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int NO_CONNECT = Integer.MAX_VALUE / 2;
        int[][] m = new int[n][n];
        for (int[] mm : m) {
            Arrays.fill(mm, NO_CONNECT);
        }
        for (int[] time : times) {
            m[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] mTime = new int[n];
        Arrays.fill(mTime, NO_CONNECT);
        mTime[k - 1] = 0;
        boolean[] hasMin = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < n; x++) {
                mTime[i] = Math.min(mTime[i], mTime[x] + m[x][k - 1]);
            }
        }
        int maxTime = 0;
        return maxTime;
    }
}