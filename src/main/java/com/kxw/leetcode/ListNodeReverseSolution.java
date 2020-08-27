package com.kxw.leetcode;

import com.kxw.leetcode.model.ListNode;

import java.util.Stack;

/**
 * @author kangxiongwei
 * @date 2020/8/26 6:44 下午
 */
public class ListNodeReverseSolution {

    public static ListNode reverse(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode h = new ListNode(-1);
        node = h;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        return h.next;
    }

    public static ListNode swap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = swap(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }



}
