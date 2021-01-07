package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 399. 除法求值
 * <p>
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 * <p>
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * <p>
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 */
public class Problem399 {

    public static void main(String... args) {
        ArrayList<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        ArrayList<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        System.out.println(JSON.toJSONString(new Problem399().calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashSet<String> hashSet = new HashSet<>();
        HashMap<String, Double> hashMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            hashSet.add(equations.get(i).get(0));
            hashSet.add(equations.get(i).get(1));
            hashMap.put(equations.get(i).get(0) + "_" + equations.get(i).get(1), values[i]);
            hashMap.put(equations.get(i).get(1) + "_" + equations.get(i).get(0), 1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; i++) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            if (hashSet.contains(x) && hashSet.contains(y)) {
                if (x.equals(y)) {
                    result[i] = 1.0;
                } else {
                    HashSet<String> set = new HashSet<>(hashSet);
                    set.remove(x);
                    set.remove(y);
                    result[i] = calc(set, hashMap, x, y, 1);
                }
            } else {
                result[i] = -1.0;
            }
        }
        return result;
    }

    public double calc(HashSet<String> hashSet, HashMap<String, Double> hashMap, String x, String y, double value) {
        String key = x + "_" + y;
        if (hashMap.containsKey(key)) {
            return hashMap.get(key) * value;
        } else if (hashSet.size() == 0) {
            return -1.0;
        } else {
            Iterator<String> iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                String xx = iterator.next();
                String key2 = x + "_" + xx;
                if (hashMap.containsKey(key2)) {
                    HashSet<String> set = new HashSet<>(hashSet);
                    set.remove(xx);
                    double v = calc(set, hashMap, xx, y, hashMap.get(key2) * value);
                    if (v != -1.0) {
                        return v;
                    }
                }
            }
            return -1.0;
        }
    }
}