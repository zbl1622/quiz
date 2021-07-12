package com.leetcode.quiz;

/**
 * 275. H 指数 II
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 * <p>
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的N - h篇论文每篇被引用次数不多于 h 次。）"
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 * 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 * <p>
 * 说明:
 * <p>
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 这是H 指数的延伸题目，本题中的citations数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/h-index-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem275 {

    public static void main(String... args) {
        int[] array = {0, 1, 3, 5, 6};
//        int[] array = {100};
//        int[] array = {0, 1};

        System.out.println(new Problem275().hIndex(array));
    }

    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        int h = 0;
        while (start <= end) {
            int index = (start + end) >> 1;
            int n = citations[index];
            if (citations.length - index <= n) {
                h = citations.length - index;
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return h;
    }
}