package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 1524. 和为奇数的子数组数目
 * <p>
 * 给你一个整数数组arr。请你返回和为 奇数的子数组数目。
 * <p>
 * 由于答案可能会很大，请你将结果对10^9 + 7取余后返回。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,3,5]
 * 输出：4
 * 解释：所有的子数组为 [[1],[1,3],[1,3,5],[3],[3,5],[5]] 。
 * 所有子数组的和为 [1,4,9,3,8,5].
 * 奇数和包括 [1,9,3,5] ，所以答案为 4 。
 * <p>
 * 示例 2 ：
 * <p>
 * 输入：arr = [2,4,6]
 * 输出：0
 * 解释：所有子数组为 [[2],[2,4],[2,4,6],[4],[4,6],[6]] 。
 * 所有子数组和为 [2,6,12,4,10,6] 。
 * 所有子数组和都是偶数，所以答案为 0 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3,4,5,6,7]
 * 输出：16
 * <p>
 * 示例 4：
 * <p>
 * 输入：arr = [100,100,99,99]
 * 输出：4
 * <p>
 * 示例 5：
 * <p>
 * 输入：arr = [7]
 * 输出：1
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-sub-arrays-with-odd-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1524 {

    public static void main(String... args) {
        int[] array = {1, 3, 5};
//        int[] array = {2, 4, 6};

        System.out.println(JSON.toJSONString(new Problem1524().numOfSubarrays(array)));
    }

    public int numOfSubarrays(int[] arr) {
        long pj = 0;
        long po = 0;
        if (arr[0] % 2 == 0) {
            po = 1;
        } else {
            pj = 1;
        }
        long s = pj;
        long dpj, dpo;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                dpj = pj;
                dpo = po + 1;
            } else {
                dpj = po + 1;
                dpo = pj;
            }
            s += dpj % 1000000007;
            pj = dpj;
            po = dpo;
        }
        return (int) (s % 1000000007);
    }
}