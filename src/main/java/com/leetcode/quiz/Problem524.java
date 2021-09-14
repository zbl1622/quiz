package com.leetcode.quiz;


import java.util.Arrays;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * <p>
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem524 {

    public static void main(String... args) {
//        String s = "abpcplea";
//        String[] array = new String[]{"ale", "apple", "monkey", "plea"};
        String s = "aaa";
        String[] array = new String[]{"aaa", "aa", "a"};


        List<String> dictionary = Arrays.asList(array);

        System.out.println(new Problem524().findLongestWord(s, dictionary));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String result = null;
        for (String word : dictionary) {
            int index_s = 0;
            int index_w = 0;
            while (index_s < s.length() && index_w < word.length()) {
                if (word.charAt(index_w) == s.charAt(index_s)) {
                    index_w += 1;
                }
                index_s += 1;
            }
            if (index_w == word.length()) {
                if (result == null) {
                    result = word;
                } else if (word.length() > result.length()) {
                    result = word;
                } else if (word.length() == result.length() && word.compareTo(result) < 0) {
                    result = word;
                }
            }
        }
        return result == null ? "" : result;
    }
}