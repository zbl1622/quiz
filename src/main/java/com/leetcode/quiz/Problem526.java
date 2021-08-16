package com.leetcode.quiz;

/**
 * 526. 优美的排列
 * 假设有从 1 到 N 的N个整数，如果从这N个数字中成功构造出一个数组，使得数组的第 i位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * <p>
 * 第i位的数字能被i整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 * <p>
 * 示例1:
 * <p>
 * 输入: 2
 * 输出: 2
 * 解释:
 * <p>
 * 第 1 个优美的排列是 [1, 2]:
 * 第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
 * 第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
 * <p>
 * 第 2 个优美的排列是 [2, 1]:
 * 第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
 * 第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
 * 说明:
 * <p>
 * N 是一个正整数，并且不会超过15。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem526 {

    public static void main(String... args) {
        int n = 15;

        System.out.println(new Problem526().countArrangement(n));
    }

    public int countArrangement(int n) {
        return find(0, 0, n);
    }

    public int find(int index, int flags, int n) {
        if (index == n - 1) {
            for (int i = 0; i < n; i++) {
                if ((flags & (1 << i)) == 0) {
                    if ((i + 1) % (index + 1) == 0 || (index + 1) % (i + 1) == 0) {
                        return 1;
                    }
                    return 0;
                }
            }
            return 0;
        } else {
            int s = 0;
            for (int i = 0; i < n; i++) {
                if ((i + 1) % (index + 1) == 0 || (index + 1) % (i + 1) == 0) {
                    if ((flags & (1 << i)) == 0) {
                        s += find(index + 1, flags | (1 << i), n);
                    }
                }
            }
            return s;
        }
    }
}