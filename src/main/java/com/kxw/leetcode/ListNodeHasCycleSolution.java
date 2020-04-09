package com.kxw.leetcode;

import com.kxw.leetcode.model.ListNode;

/**
 * 判断给定的链表是否有环
 *
 * @author kangxiongwei
 * @date 2020-04-09 12:31
 */
public class ListNodeHasCycleSolution {

    public static void main(String[] args) {
        ListNodeHasCycleSolution solution = new ListNodeHasCycleSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node1;
        node3.next = node2;
        boolean cycle = solution.hasCycle(node1);
        System.out.println(cycle);
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


}
