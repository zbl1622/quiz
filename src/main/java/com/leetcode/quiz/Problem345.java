package com.leetcode.quiz;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem345 {

    public static void main(String... args) {
        String s = ".,";

        System.out.println(new Problem345().reverseVowels(s));
    }

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while (left < right && left < c.length && right >= 0) {
            while (c[left] != 'a' && c[left] != 'e' && c[left] != 'i' && c[left] != 'o' && c[left] != 'u' && c[left] != 'A' && c[left] != 'E' && c[left] != 'I' && c[left] != 'O' && c[left] != 'U' && left < right) {
                left += 1;
            }
            while (c[right] != 'a' && c[right] != 'e' && c[right] != 'i' && c[right] != 'o' && c[right] != 'u' && c[right] != 'A' && c[right] != 'E' && c[right] != 'I' && c[right] != 'O' && c[right] != 'U' && right > left) {
                right -= 1;
            }
            if (left < right) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left += 1;
                right -= 1;
            }
        }
        return new String(c);
    }
}