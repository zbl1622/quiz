package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * <p>
 * 已有方法rand7可生成 1 到 7 范围内的均匀随机整数，试写一个方法rand10生成 1 到 10 范围内的均匀随机整数。
 * <p>
 * 不要使用系统的Math.random()方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [7]
 * <p>
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [8,4]
 * <p>
 * 示例 3:
 * <p>
 * 输入: 3
 * 输出: [8,1,10]
 * <p>
 * <p>
 * 提示:
 * <p>
 * rand7已定义。
 * 传入参数:n表示rand10的调用次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem470 {

    public static void main(String... args) {

        Problem470 p = new Problem470();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            int r = p.rand10();
            hashMap.put(r, hashMap.getOrDefault(r, 0) + 1);
        }
        for (Integer k : hashMap.keySet()) {
            System.out.println(k + ":" + hashMap.get(k));
        }
    }

    public int rand10() {
        int r = 0;
        int offset = 0;
        do {
            r = rand7();
        } while (r == 4);
        if (r < 4) {
            offset = 0;
        } else {
            offset = 5;
        }
        do {
            r = rand7();
        } while (r > 5);
        return r + offset;
    }

    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}