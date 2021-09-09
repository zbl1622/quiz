package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 68. 文本左右对齐(未解决)
 * <p>
 * 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于maxWidth。
 * 输入单词数组 words至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This  is  an",
 * "example of text",
 * "justification. "
 * ]
 * <p>
 * 示例2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What  must  be",
 * "acknowledgment ",
 * "shall be    "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * <p>
 * 示例3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science is what we",
 * "understand   well",
 * "enough to explain to",
 * "a computer. Art is",
 * "everything else we",
 * "do         "
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem68 {

    public static void main(String... args) {
        String[] words = {
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        };
        int maxWidth = 20;

        System.out.println(JSON.toJSONString(new Problem68().fullJustify(words, maxWidth)));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int start = index;
            int w = 0;
            while (index < words.length) {
                w += words[index].length();
                if (w == maxWidth) {
                    break;
                } else if (w > maxWidth) {
                    w -= words[index].length();
                    w -= 1;
                    break;
                }
                index += 1;
                w += 1;
            }
            if (index == words.length) {
                StringBuilder sb = new StringBuilder();
                for (int i = start; i < index; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                list.add(sb.toString());
            } else {
                int extraSpace = (maxWidth - w) / (index - start);
                int modSpace = (maxWidth - w) % (index - start);
                StringBuilder sb = new StringBuilder();
                for (int i = start; i < index; i++) {
                    sb.append(words[i]);
                    if (i != index - 1) {
                        for (int j = 0; j <= extraSpace; j++) {
                            sb.append(' ');
                        }
                        if (modSpace > 0) {
                            sb.append(' ');
                            modSpace -= 1;
                        }
                    }
                }
                list.add(sb.toString());
            }
        }
        return list;
    }
}