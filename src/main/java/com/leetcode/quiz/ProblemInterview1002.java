package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 面试题 10.02. 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProblemInterview1002 {

    public static void main(String... args) {
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(JSON.toJSONString(new ProblemInterview1002().groupAnagrams(array)));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] values = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        HashMap<Integer, List<String>> hashMap = new HashMap();
        for (String str : strs) {
            int key = 1;
            for (char c : str.toCharArray()) {
                key *= values[c - 'a'];
            }
            List<String> list = hashMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                hashMap.put(key, list);
            }
            list.add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
}