package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 767. 重构字符串
 * <p>
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 */
public class Problem767 {

    public static void main(String... args) {
//        String s = "aab";
        String s = "aaab";
        System.out.println(new Problem767().reorganizeString(s));
    }

    public String reorganizeString(String s) {
        ArrayList<int[]> list = new ArrayList();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.merge(c, 1, Integer::sum);
        }
        for (char c : hashMap.keySet()) {
            list.add(new int[]{c, hashMap.get(c)});
        }
        list.sort(Comparator.comparingInt(t0 -> ((int[]) t0)[1]));
        StringBuilder sb = new StringBuilder();
        int lastCharacter = '_';
        while (list.size() > 0) {
            int index = list.size() - 1;
            int[] object = list.get(index);
            if (object[0] == lastCharacter) {
                index -= 1;
                if (index < 0) {
                    return "";
                } else {
                    object = list.get(index);
                }
            }
            lastCharacter = object[0];
            sb.append((char) object[0]);
            object[1] = object[1] - 1;
            if (object[1] == 0) {
                list.remove(index);
            } else {
                sort(list, index);
            }
        }
        return sb.toString();
    }

    public void sort(ArrayList<int[]> list, int index) {
        while (index > 0) {
            if (list.get(index - 1)[1] > list.get(index)[1]) {
                swap(list, index, index - 1);
                index -= 1;
            } else {
                break;
            }
        }
    }

    public void swap(ArrayList<int[]> list, int a, int b) {
        int[] object = list.get(a);
        list.set(a, list.get(b));
        list.set(b, object);
    }
}
