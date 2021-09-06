package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * <p>
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345"
 * 输出：["12345"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * S的长度不超过12。
 * S仅由数字和字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem784 {

    public static void main(String... args) {
        String s = "a1b2";

        System.out.println(JSON.toJSONString(new Problem784().letterCasePermutation(s)));
    }

    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>();
        recurse(list, sb, s, 0);
        return list;
    }

    public void recurse(List<String> list, StringBuilder sb, String s, int index) {
        if (index == s.length()) {
            list.add(sb.toString());
            return;
        }
        int i = index;
        char c = s.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            sb.append(c);
            recurse(list, sb, s, index + 1);
            sb.setLength(sb.length() - 1);
            sb.append((char) (c + ('a' - 'A')));
            recurse(list, sb, s, index + 1);
            sb.setLength(sb.length() - 1);
        } else if (c >= 'a' && c <= 'z') {
            sb.append(c);
            recurse(list, sb, s, index + 1);
            sb.setLength(sb.length() - 1);
            sb.append((char) (c - ('a' - 'A')));
            recurse(list, sb, s, index + 1);
            sb.setLength(sb.length() - 1);
        } else {
            sb.append(c);
            recurse(list, sb, s, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}