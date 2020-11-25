package com.leetcode.quiz;

/**
 * 147. 对链表进行插入排序
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 */
public class Problem147 {

    public static void main(String... args) {
        ListNode head = generateLinkedList(new int[]{4, 2, 1, 3});
//        ListNode head = generateLinkedList(new int[]{-2147483647, -2147483648});
        head = new Problem147().insertionSortList(head);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode resultHead = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode cNode = head;
            head = head.next;
            cNode.next = null;
            ListNode node = resultHead;
            boolean inserted = false;
            while (node.next != null) {
                if (cNode.val <= node.next.val) {
                    cNode.next = node.next;
                    node.next = cNode;
                    inserted = true;
                    break;
                }
                node = node.next;
            }
            if (!inserted) {
                if (cNode.val < node.val) {
                    cNode.next = node;
                }
                node.next = cNode;
            }
        }
        return resultHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode generateLinkedList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int n : array) {
            node.next = new ListNode(n);
            node = node.next;
        }
        return head.next;
    }
}