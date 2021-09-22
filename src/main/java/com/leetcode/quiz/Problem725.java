package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * 725. 分隔链表
 * <p>
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem725 {

    public static void main(String... args) {
        int[] array = {1, 2, 3};
        int k = 5;
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int k = 3;

        System.out.println(JSON.toJSONString(new Problem725().splitListToParts(createList(array), k)));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length += 1;
            node = node.next;
        }
        ListNode[] listNodes = new ListNode[k];
        int size = length / k;
        int mod = length % k;
        int i = 0;
        while (i < k) {
            listNodes[i] = head;
            ListNode pre = head;
            int j = 0;
            while (j < size) {
                if (head != null) {
                    pre = head;
                    head = head.next;
                }
                j += 1;
            }
            if (mod > 0) {
                if (head != null) {
                    pre = head;
                    head = head.next;
                }
                mod -= 1;
            }
            if (pre != null) {
                pre.next = null;
            }
            i += 1;
        }
        return listNodes;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode createList(int[] array) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int n : array) {
            node.next = new ListNode(n);
            node = node.next;
        }
        return head.next;
    }
}