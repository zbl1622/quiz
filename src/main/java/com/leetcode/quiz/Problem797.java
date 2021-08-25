package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * <p>
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * <p>
 * 示例 5：
 * <p>
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即，不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem797 {

    public static void main(String... args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
//        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};

        System.out.println(JSON.toJSONString(new Problem797().allPathsSourceTarget(graph)));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<>();
        findPath(graph, lists, new ArrayList<>(), 0, graph.length - 1);
        return lists;
    }

    public void findPath(int[][] graph, List<List<Integer>> lists, List<Integer> path, int node, int target) {
        if (node == target) {
            path.add(target);
            lists.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        } else {
            int[] childArray = graph[node];
            if (childArray.length > 0) {
                for (int n : childArray) {
                    path.add(node);
                    findPath(graph, lists, path, n, target);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}