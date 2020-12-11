package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 */
public class Problem118 {

    public static void main(String... args) {
        int numRows = 5;

        System.out.println(JSON.toJSONString(new Problem118().generate(numRows)));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        if (numRows > 0) {
            list.add(Collections.singletonList(1));
        }
        if (numRows > 1) {
            list.add(Arrays.asList(1, 1));
        }
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> lastRow = list.get(i - 1);
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}