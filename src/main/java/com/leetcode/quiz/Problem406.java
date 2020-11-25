package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

/**
 * 406. 根据身高重建队列
 * <p>
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 */
public class Problem406 {

    public static void main(String... args) {
        int[][] people = new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        System.out.println(JSON.toJSONString(new Problem406().reconstructQueue(people)));
    }

    public int[][] reconstructQueue(int[][] people) {
        sort(people);
        for (int i = people.length - 1; i >= 0; i--) {
            int moveCount = people[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (people[j][0] == people[i][0]) {
                    moveCount -= 1;
                } else {
                    break;
                }
            }
            int moveStep = 0;
            int j = 0;
            while (moveStep < moveCount) {
                if (people[i + j][0] <= people[i + j + 1][0]) {
                    moveStep += 1;
                }
                swap(people, i + j, i + j + 1);
                j += 1;
            }
        }
        return people;
    }

    public void sort(int[][] people) {
        for (int i = 0; i < people.length; i++) {
            int j = i;
            while (j > 0) {
                if (people[j][0] < people[j - 1][0]) {
                    swap(people, j, j - 1);
                    j -= 1;
                } else if (people[j][0] == people[j - 1][0] && people[j][1] < people[j - 1][1]) {
                    swap(people, j, j - 1);
                    j -= 1;
                } else {
                    break;
                }
            }
        }
    }

    public void swap(int[][] people, int a, int b) {
        int[] temp = people[a];
        people[a] = people[b];
        people[b] = temp;
    }
}