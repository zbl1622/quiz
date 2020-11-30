package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 769. 最多能完成排序的块
 * <p>
 * 数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 我们最多能将数组分成多少块？
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * <p>
 * 示例 2:
 * <p>
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 * 注意:
 * <p>
 * arr 的长度在 [1, 10] 之间。
 * arr[i]是 [0, 1, ..., arr.length - 1]的一种排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-chunks-to-make-sorted
 */
public class Problem769 {

    public static void main(String... args) {
//        int[] array = new int[]{1, 0, 2, 4, 3};
//        int[] array = new int[]{4, 3, 2, 1, 0};
//        int[] array = new int[]{1, 0, 2, 3, 4};
        int[] array = new int[]{1, 2, 0, 3};
        System.out.println(new Problem769().maxChunksToSorted(array));
    }

    public int maxChunksToSorted(int[] arr) {
        int sum = 0;
        int indexStart = 0;
        int findCount = 0;
        int maxIndex = 0;
        int cCount = 0;
        int index = 0;
        int status = 0;
        while (index < arr.length) {
            if (status == 0) {
                if (arr[index] == index) {
                    sum += 1;
                } else {
                    maxIndex = arr[index];
                    indexStart = index;
                    findCount = 0;
                    cCount = maxIndex - index;
                    status = 1;
                }
            } else {
                findCount += 1;
                if (arr[index] < maxIndex) {
                    cCount -= 1;
                    if (cCount == 0) {
                        sum += 1;
                        status = 0;
                    }
                } else {
                    maxIndex = arr[index];
                    cCount = maxIndex - indexStart - findCount;
                }

            }
            index += 1;
        }
        return sum;
    }
}
