package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 212. 单词搜索 II
 * <p>
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [['o','a','a','n'],['e','t','a','e'],['i','h','k','r'],['i','f','l','v']], words = ['oath','pea','eat','rain']
 * 输出：['eat','oath']
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [['a','b'],['c','d']], words = ['abcb']
 * 输出：[]
 *
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem212 {

    public static void main(String... args) {
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//        String[] words = {"oath","pea","eat","rain"};
//        char[][] board = {
//                {'a', 'b'},
//                {'c', 'd'}
//        };
//        String[] words = {"abcb"};
//        char[][] board = {
//                {'a', 'b', 'c', 'e'},
//                {'x', 'x', 'c', 'd'},
//                {'x', 'x', 'b', 'a'}
//        };
//        String[] words = {"abc", "abcd"};
//        char[][] board = {
//                {'a', 'b', 'c'},
//                {'a', 'e', 'd'},
//                {'a', 'f', 'g'}
//        };
//        String[] words = {"eaafgdcba", "eaabcdgfa"};
//        char[][] board = {
//                {'a'}
//        };
//        String[] words = {"a"};
        char[][] board = {
                {'a', 'b'},
                {'a', 'a'}
        };
        String[] words = {"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};

        System.out.println(JSON.toJSONString(new Problem212().findWords(board, words)));
    }

    class Trie {
        public String value;
        public boolean isWord;
        public HashMap<Character, Trie> children = new HashMap<>();

        public Trie(String value, boolean isWord) {
            this.value = value;
            this.isWord = isWord;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        Trie root = new Trie("", false);
        for (String word : words) {
            Trie trie = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie t = trie.children.get(c);
                if (t == null) {
                    t = new Trie(word.substring(0, i + 1), i == word.length() - 1);
                    trie.children.put(c, t);
                } else {
                    t.isWord = t.isWord || i == word.length() - 1;
                }
                trie = t;
            }
        }
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return new ArrayList<>(result);
    }

    public void dfs(char[][] board, int i, int j, Trie trie, HashSet<String> result) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        char c = board[i][j];
        if (trie.children.containsKey(c)) {
            System.out.println("check:" + trie.value);
            trie = trie.children.get(c);
            if (trie.isWord) {
                result.add(trie.value);
            }
            board[i][j] = '#';
            dfs(board, i - 1, j, trie, result);
            dfs(board, i, j - 1, trie, result);
            dfs(board, i + 1, j, trie, result);
            dfs(board, i, j + 1, trie, result);
            board[i][j] = c;
        }
    }
}