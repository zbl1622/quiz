package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 面试题 17.14. 最小K个数
 * <p>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProblemInterview1714 {

    public static void main(String... args) {
        int[] array = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;

        System.out.println(JSON.toJSONString(new ProblemInterview1714().smallestK(array, k)));
    }

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int center = (left + right) / 2;
                if (list.get(center) <= arr[i]) {
                    left = center + 1;
                } else {
                    right = center - 1;
                }
            }
            list.add(left, arr[i]);
            if (list.size() > k) {
                list.remove(list.size() - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}