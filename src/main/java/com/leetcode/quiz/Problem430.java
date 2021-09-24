package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 430. 扁平化多级双向链表
 * <p>
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem430 {

    public static void main(String... args) {

//        System.out.println(JSON.toJSONString(new Problem430().flatten(array)));
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            if (node.child != null) {
                if (node.next != null) {
                    stack.push(node.next);
                }
                node.next = node.child;
                node.next.prev = node;
                node.child = null;
            } else if (node.next == null && !stack.isEmpty()) {
                Node pop = stack.pop();
                node.next = pop;
                pop.prev = node;
            }
            node = node.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}