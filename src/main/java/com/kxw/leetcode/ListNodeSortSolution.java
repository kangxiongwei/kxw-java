package com.kxw.leetcode;

import com.kxw.leetcode.model.ListNode;

/**
 * 归并排序
 *
 * @author kangxiongwei
 * @date 2020-03-31 07:56
 */
public class ListNodeSortSolution {

    public static void main(String[] args) {
        ListNodeSortSolution solution = new ListNodeSortSolution();
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(7);
        ListNode node = solution.sortList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode next = middle.next;
        middle.next = null;
        return mergeLists(sortList(head), sortList(next));
    }

    /**
     * 获取中间的节点
     *
     * @param head
     * @return
     */
    private ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 归并排序合并两个List
     *
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = new ListNode(0);
        ListNode h1 = head1;
        ListNode h2 = head2;
        ListNode mergeHead = head;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                mergeHead.next = h1;
                h1 = h1.next;
            } else {
                mergeHead.next = h2;
                h2 = h2.next;
            }
            mergeHead = mergeHead.next;
        }
        if (h1 != null) {
            mergeHead.next = h1;
        }
        if (h2 != null) {
            mergeHead.next = h2;
        }
        return head.next;
    }


}
