package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 * <p>
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "aba"
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem830 {

    public static void main(String... args) {
//        String s = "abcdddeeeeaabbbcd";
        String s = "aaa";

        System.out.println(JSON.toJSONString(new Problem830().largeGroupPositions(s)));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        char[] chars = s.toCharArray();
        char lastChar = ' ';
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != lastChar) {
                if (i - start > 2) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(start);
                    list.add(i - 1);
                    lists.add(list);
                }
                start = i;
                lastChar = chars[i];
            }
        }
        if (chars.length - start > 2) {
            List<Integer> list = new ArrayList<>(2);
            list.add(start);
            list.add(chars.length - 1);
            lists.add(list);
        }
        return lists;
    }
}