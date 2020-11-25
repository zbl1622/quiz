package com.leetcode.quiz;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 */
public class Problem135 {

    public static void main(String... args) {
//        int[] ratings = new int[]{1, 2, 2};
        int[] ratings = new int[]{5, 3, 7, 3};
        System.out.println(String.valueOf(new Problem135().candy(ratings)));
    }

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] candy = new int[ratings.length];
        System.arraycopy(ratings, 0, candy, 0, ratings.length);

        for (int d : new int[]{1, -1}) {
            int i = d == 1 ? 0 : candy.length - 1;
            if (ratings[i] > ratings[i + d]) {
                candy[i] = candy[i + d] + 1;
            } else if (ratings[i] < ratings[i + d]) {
                candy[i] = 0;
            } else {
                candy[i] = 0;
            }
            i += d;
            for (; i > 0 && i < candy.length - 1; i += d) {
                if (ratings[i] > ratings[i + d]) {
                    if (ratings[i] > ratings[i - d]) {
                        candy[i] = Math.max(candy[i + d], candy[i - d]) + 1;
                    } else if (ratings[i] < ratings[i - d]) {
                        candy[i] = candy[i + d] + 1;
                    } else {
                        candy[i] = candy[i + d] + 1;
                    }
                } else if (ratings[i] < ratings[i + d]) {
                    if (ratings[i] > ratings[i - d]) {
                        candy[i] = candy[i - d] + 1;
                    } else if (ratings[i] < ratings[i - d]) {
                        candy[i] = 0;
                    } else {
                        candy[i] = 0;
                    }
                } else {
                    if (ratings[i] > ratings[i - d]) {
                        candy[i] = candy[i - d] + 1;
                    } else if (ratings[i] < ratings[i - d]) {
                        candy[i] = 0;
                    } else {
                        candy[i] = 0;
                    }
                }
            }
            i += d;
        }
        if (ratings[0] > ratings[1]) {
            candy[0] = candy[1] + 1;
        } else if (ratings[0] < ratings[1]) {
            candy[0] = 0;
        } else {
            candy[0] = 0;
        }

        int sum = 0;
        boolean hasZero = false;
        for (int n : candy) {
            if (n == 0) {
                hasZero = true;
            }
            sum += n;
        }
        if (hasZero) {
            sum += candy.length;
        }
        return sum;
    }
}