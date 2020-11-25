package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class Problem49 {

    public static void main(String... args) {
//        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"};
//        String[] array = {"ron", "huh", "gay", "tow", "moe", "tie", "who", "ion", "rep", "bob", "gte", "lee", "jay", "may", "wyo", "bay", "woe", "lip", "tit", "apt", "doe", "hot", "dis", "fop", "low", "bop", "apt", "dun", "ben", "paw", "ere", "bad", "ill", "fla", "mop", "tut", "sol", "peg", "pop", "les"};
//        String[] array = {"fin", "ell"};
//        String[] array = {"run", "had", "lot", "kim", "fat", "net", "fin", "rca", "chi", "lei", "lox", "iva", "liz", "hug", "hot", "irk", "lap", "tan", "tux", "yuk", "hep", "map", "ran", "ell", "kit", "put", "non", "aol", "add", "lad", "she", "job", "mes", "pen", "vic", "fag", "bud", "ken", "nod", "jam", "coy", "hui", "sue", "nap", "ton", "coy", "rut", "fit", "cut", "eta", "our", "oho", "zip"};
        System.out.println(JSON.toJSONString(new Problem49().groupAnagrams(array)));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        char[] array = new char[26];
        for (String str : strs) {
            Arrays.fill(array, '\0');
            for (char c : str.toCharArray()) {
                array[c - 'a'] += 1;
            }
            List<String> list = map.computeIfAbsent(new String(array), k -> new LinkedList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}