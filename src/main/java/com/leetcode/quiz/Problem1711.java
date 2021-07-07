package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 1711. 大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 * <p>
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= deliciousness.length <= 10^5
 * 0 <= deliciousness[i] <= 2^20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1711 {

    public static void main(String... args) {
//        int[] array = {1, 3, 5, 7, 9};
//        int[] array = {1, 1, 1, 3, 3, 3, 7};
        int[] array = {149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234};

        System.out.println(new Problem1711().countPairs(array));
    }

    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int s = 0;
        long n = 1;
        int mod = 1000000007;
        for (int i = 0; i <= 21; i++) {
            hashMap.clear();
            for (int j = 0; j < deliciousness.length; j++) {
                int x = (int) (n - deliciousness[j]);
                if (hashMap.containsKey(x)) {
                    s = (s + hashMap.get(x)) % mod;
                }
                hashMap.put(deliciousness[j], hashMap.getOrDefault(deliciousness[j], 0) + 1);
            }
            n <<= 1;
        }
        return s;
    }
}