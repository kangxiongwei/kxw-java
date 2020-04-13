package com.kxw.leetcode.interview;

import com.kxw.leetcode.factory.ListNodeFactory;
import com.kxw.leetcode.model.ListNode;
import com.kxw.leetcode.utils.ListNodeUtil;

/**
 * 给定单调递增的单链表，移除所有出现的重复元素
 * 1 2 2 3 3 4 5 --> 1 4 5
 * 2 2 3 3 3 4 5 --> 4 5
 *
 * @author kangxiongwei
 * @date 2020-04-13 17:02
 */
public class ListNodeRemoveDuplicateSolution {

    public static void main(String[] args) {
        ListNodeRemoveDuplicateSolution solution = new ListNodeRemoveDuplicateSolution();
        ListNode head = ListNodeFactory.buildLinkedList(new int[] {2,2,3,3,3,4,5});
        ListNode listNode = solution.removeDuplicateNode(head);
        String node = ListNodeUtil.printListNode(listNode);
        System.out.println(node);
    }


    public ListNode removeDuplicateNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode node = newHead;
        while (node != null && node.next != null) {
            ListNode slow = node.next;
            ListNode fast = node.next.next;
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                node.next = slow;
            } else {
                node.next = removeDuplicateNode(fast);
            }
            node = node.next;
        }
        return newHead.next;
    }



}
