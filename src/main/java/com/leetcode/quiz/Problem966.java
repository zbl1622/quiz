package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 966. 元音拼写检查器
 * <p>
 * 在给定单词列表wordlist的情况下，我们希望实现一个拼写检查器，将查询单词转换为正确的单词。
 * <p>
 * 对于给定的查询单词query，拼写检查器将会处理两类拼写错误：
 * <p>
 * 大小写：如果查询匹配单词列表中的某个单词（不区分大小写），则返回的正确单词与单词列表中的大小写相同。
 * 例如：wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * 例如：wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * 例如：wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * 元音错误：如果在将查询单词中的元音（‘a’、‘e’、‘i’、‘o’、‘u’）分别替换为任何元音后，能与单词列表中的单词匹配（不区分大小写），则返回的正确单词与单词列表中的匹配项大小写相同。
 * 例如：wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * 例如：wordlist = ["YellOw"], query = "yeellow": correct = "" （无匹配项）
 * 例如：wordlist = ["YellOw"], query = "yllw": correct = "" （无匹配项）
 * 此外，拼写检查器还按照以下优先级规则操作：
 * <p>
 * 当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。
 * 当查询匹配到大小写问题的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 如果该查询在单词列表中没有匹配项，则应返回空字符串。
 * 给出一些查询 queries，返回一个单词列表 answer，其中 answer[i] 是由查询 query = queries[i] 得到的正确单词。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * 输出：["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= wordlist.length <= 5000
 * 1 <= queries.length <= 5000
 * 1 <= wordlist[i].length <= 7
 * 1 <= queries[i].length <= 7
 * wordlist 和queries中的所有字符串仅由英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vowel-spellchecker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem966 {

    public static void main(String... args) {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
//        String[] wordlist = {"zeo", "Zuo"};
//        String[] queries = {"zuo"};

        System.out.println(JSON.toJSONString(new Problem966().spellchecker(wordlist, queries)));
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        HashMap<String, LinkedHashSet<String>> caseMap = new HashMap<>();
        HashMap<String, LinkedHashSet<String>> hashMap = new HashMap<>();
        int diff = 'a' - 'A';
        for (String word : wordlist) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < 'a') {
                    chars[i] += diff;
                }
            }
            String key1 = new String(chars);
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                    chars[i] = 'a';
                }
            }
            String key2 = new String(chars);
            LinkedHashSet<String> set = caseMap.get(key1);
            if (set == null) {
                set = new LinkedHashSet<>();
                caseMap.put(key1, set);
            }
            set.add(word);
            set = hashMap.get(key2);
            if (set == null) {
                set = new LinkedHashSet<>();
                hashMap.put(key2, set);
            }
            set.add(word);
        }
        for (int j = 0; j < queries.length; j++) {
            String query = queries[j];
            char[] chars = query.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < 'a') {
                    chars[i] += diff;
                }
            }
            String key1 = new String(chars);
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                    chars[i] = 'a';
                }
            }
            String key2 = new String(chars);
            LinkedHashSet<String> set = caseMap.get(key1);
            if (set == null) {
                set = hashMap.get(key2);
                if (set == null) {
                    result[j] = "";
                } else {
                    result[j] = set.iterator().next();
                }
            } else {
                if (set.contains(query)) {
                    result[j] = query;
                } else {
                    result[j] = set.iterator().next();
                }
            }
        }
        return result;
    }
}