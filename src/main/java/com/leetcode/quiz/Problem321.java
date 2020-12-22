package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 402. 移掉K位数字（未解决）
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 */
public class Problem321 {

    public static void main(String... args) {
//        int[] nums1 = new int[]{3, 4, 6, 5};
//        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
//        int k = 5;
//        int[] nums1 = new int[]{6, 7};
//        int[] nums2 = new int[]{6, 0, 4};
//        int k = 5;
//        int[] nums1 = new int[]{8, 9};
//        int[] nums2 = new int[]{3, 9};
//        int k = 3;
        int[] nums1 = new int[]{1, 6, 5, 4, 7, 3, 9, 5, 3, 7, 8, 4, 1, 1, 4};
        int[] nums2 = new int[]{4, 3, 1, 3, 5, 9};
        int k = 21;
        System.out.println(Arrays.toString(new Problem321().maxNumber(nums1, nums2, k)));
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        resultList.clear();
        findMaxNumber(result, nums1, nums2, 0, 0, k);
        return (int[]) resultList.get(0);
    }

    private ArrayList<Object> resultList = new ArrayList<>();

    public void findMaxNumber(int[] result, int[] nums1, int[] nums2, int index1, int index2, int k) {
        if (k == 0) {
            int[] r = new int[result.length];
            System.arraycopy(result, 0, r, 0, result.length);
            resultList.add(r);
            return;
        }
        Set<Integer> skipSet1 = new HashSet<>();
        Set<Integer> skipSet2 = new HashSet<>();
        int[] maxIndexArray = findMaxIndex(nums1, nums2, index1, index2, skipSet1, skipSet2, k);
        for (int maxIndex : maxIndexArray) {
            if (maxIndex < nums1.length) {
                index1 = maxIndex;
                result[result.length - k] = nums1[index1];
                index1 += 1;
            } else {
                maxIndex = maxIndex - nums1.length;
                index2 = maxIndex;
                result[result.length - k] = nums2[index2];
                index2 += 1;
            }
            findMaxNumber(result, nums1, nums2, index1, index2, k - 1);
        }
    }

    public int[] findMaxIndex(int[] nums1, int[] nums2, int start1, int start2, Set<Integer> skipSet1, Set<Integer> skipSet2, int k) {
        int max1 = -1, maxIndex1 = 0;
        for (int i = start1; i < nums1.length; i++) {
            if (skipSet1.contains(i)) {
                continue;
            }
            if (nums1[i] > max1) {
                max1 = nums1[i];
                maxIndex1 = i;
            }
        }
        int max2 = -1, maxIndex2 = 0;
        for (int i = start2; i < nums2.length; i++) {
            if (skipSet2.contains(i)) {
                continue;
            }
            if (nums2[i] > max2) {
                max2 = nums2[i];
                maxIndex2 = i + nums1.length;
            }
        }
        if (max1 > max2) {
            if (nums1.length - maxIndex1 + nums2.length - start2 >= k) {
                return new int[]{maxIndex1};
            } else {
                skipSet1.add(maxIndex1);
                return findMaxIndex(nums1, nums2, start1, start2, skipSet1, skipSet2, k);
            }
        } else if (max1 < max2) {
            if (nums1.length - start1 + nums2.length - maxIndex2 >= k) {
                return new int[]{maxIndex2};
            } else {
                skipSet2.add(maxIndex2 - nums1.length);
                return findMaxIndex(nums1, nums2, start1, start2, skipSet1, skipSet2, k);
            }
        } else {
            return new int[]{maxIndex1, maxIndex2};
        }
    }
}