package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 187. 重复的DNA序列
 * <p>
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * 
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * 
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem187 {

    public static void main(String... args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(JSON.toJSONString(new Problem187().findRepeatedDnaSequences(s)));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<String> stringSet = new HashSet<>();
        int n = 0;
        for (int i = 0; i < 10; i++) {
            n = n << 2;
            n += convert(chars[i]);
        }
        hashSet.add(n);
        for (int i = 10; i < chars.length; i++) {
            n = n & 0b00111111111111111111;
            n = n << 2;
            n += convert(chars[i]);
            if (hashSet.contains(n)) {
                stringSet.add(s.substring(i - 9, i + 1));
            } else {
                hashSet.add(n);
            }
        }
        return new ArrayList<>(stringSet);
    }

    public int convert(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            default:
                return 3;
        }
    }
}