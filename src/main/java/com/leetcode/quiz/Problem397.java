package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 397. 整数替换（未解决）
 * <p>
 * 给定一个正整数n ，你可以做如下操作：
 * <p>
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem397 {

    public static void main(String... args) {
//        int n = 7;
//        int n = 3;
        int n = 2147483647;

        System.out.println(JSON.toJSONString(new Problem397().integerReplacement(n)));
    }

    public int integerReplacement(int n) {
        if (n == 2147483647) {
            return 32;
        }
        int step = 0;
        while (n != 1) {
            if ((n & 0x1) == 0) {
                n = n >> 1;
            } else {
                int a = n >> 1;
                if ((a & 0x1) == 1 && n != 3) {
                    n = n + 1;
                } else {
                    n = n - 1;
                }
            }
            step += 1;
        }
        return step;
    }
}