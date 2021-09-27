package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 583. 两个字符串的删除操作
 * <p>
 * 给定两个单词word1和word2，找到使得word1和word2相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem583 {

    public static void main(String... args) {
        String word1 = "sea", word2 = "eat";
//        String word1 = "leetcode", word2 = "etco";
//        String word1 = "park", word2 = "spake";

        System.out.println(JSON.toJSONString(new Problem583().minDistance(word1, word2)));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }else {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        int max = dp[word1.length() - 1][word2.length() - 1];
        return word1.length() - max + word2.length() - max;
    }
}