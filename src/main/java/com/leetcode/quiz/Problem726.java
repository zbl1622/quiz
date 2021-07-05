package com.leetcode.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * 726. 原子的数量
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * <p>
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * <p>
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * <p>
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * <p>
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * <p>
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem726 {

    public static void main(String... args) {
        String formula = "K4(ON(SO3)2)2";

        System.out.println(new Problem726().countOfAtoms(formula));
    }

    public String countOfAtoms(String formula) {
        char[] data = formula.toCharArray();
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        int index = 0;
        HashMap<String, Integer> countMap = new HashMap<>();
        while (index < data.length) {
            char c = data[index];
            if (c == '(') {
                stack.push(countMap);
                countMap = new HashMap<>();
                index += 1;
            } else if (c == ')') {
                index += 1;
                HashMap<String, Integer> savedMap = countMap;
                countMap = stack.pop();
                int[] r = readNumber(data, index);
                index += r[1];
                for (String element : savedMap.keySet()) {
                    addElementCount(countMap, element, savedMap.get(element) * r[0]);
                }
            } else if (c >= 'A' && c <= 'Z') {
                Object[] r = readElement(data, index);
                index += (int) r[1];
                int[] rn = readNumber(data, index);
                index += rn[1];
                addElementCount(countMap, (String) r[0], rn[0]);
            }
        }
        ArrayList<String> elementList = new ArrayList<>(countMap.keySet());
        Collections.sort(elementList);
        StringBuilder sb = new StringBuilder();
        for (String element : elementList) {
            sb.append(element);
            int count = countMap.get(element);
            if (count != 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    private Object[] readElement(char[] data, int index) {
        StringBuilder sb = new StringBuilder();
        int i = index;
        do {
            sb.append(data[i]);
            i += 1;
        } while (i < data.length && data[i] >= 'a' && data[i] <= 'z');
        return new Object[]{
                sb.toString(), i - index
        };
    }

    private int[] readNumber(char[] data, int index) {
        int s = 0;
        int i = index;
        while (i < data.length && data[i] >= '0' && data[i] <= '9') {
            s *= 10;
            s += data[i] - '0';
            i += 1;
        }
        if (s == 0) {
            s = 1;
        }
        return new int[]{
                s, i - index
        };
    }

    private void addElementCount(HashMap<String, Integer> countMap, String element, int count) {
        if (countMap.containsKey(element)) {
            countMap.put(element, countMap.get(element) + count);
        } else {
            countMap.put(element, count);
        }
    }
}